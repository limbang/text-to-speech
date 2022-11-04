/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.tts

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.*
import okio.ByteString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import top.limbang.tts.entity.SpeechConfig
import top.limbang.tts.entity.SpeechRequest
import top.limbang.tts.entity.SpeechRequest.ContentType.JSON
import top.limbang.tts.entity.SpeechRequest.ContentType.SSML_XML
import top.limbang.tts.entity.SynthesisContext
import java.io.ByteArrayOutputStream
import java.util.*

class TextToSpeech(private val client: OkHttpClient = OkHttpClient.Builder().build()) {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)
    private val json = Json { encodeDefaults = true }

    /**
     * ## 文字转语音
     *
     * @param ssml ssml格式内容
     */
    suspend fun convert(ssml: String): ByteArray = withContext(Dispatchers.IO) {
        val connectionId = createID()
        val url = "wss://eastus.api.speech.microsoft.com/cognitiveservices/websocket/v1?TrafficType=AzureDemo&Authorization=bearer%20undefine&X-ConnectionId=$connectionId"

        val request = Request.Builder()
            .header("Origin","https://azure.microsoft.com")
            .url(url)
            .build()
        var isClose = false
        val bos = ByteArrayOutputStream()
        client.newWebSocket(request, object : WebSocketListener() {
            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                isClose = true
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                logger.error(t.localizedMessage)
                println(t)
                isClose = true
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                if (text.indexOf("Path:turn.end") != -1) {
                    webSocket.close(1000, null)
                }
            }

            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                // 获取数据头的长度
                val headSize = bytes.substring(0, 2).hex().toInt(16)
                // 写入真正的数据
                bytes.substring(headSize + 2, bytes.size).write(bos)
            }

            override fun onOpen(webSocket: WebSocket, response: Response) {
                logger.debug("连接成功...")
                // 发送语音配置
                webSocket.send(createSpeechConfig(connectionId))
                // 发送合成配置
                webSocket.send(createSynthesisContext(connectionId))
                // 发送ssml配置
                webSocket.send(createSSML(connectionId, ssml))
            }
        })
        while (!isClose) {
            delay(200)
        }
        bos.toByteArray()
    }


    /**
     * ## 创建语音配置
     *
     * @param connectionId uuid
     */
    private fun createSpeechConfig(connectionId: String) =
        SpeechRequest(SpeechRequest.Path.SpeechConfig, connectionId, JSON, json.encodeToString(SpeechConfig())).toString()

    /**
     * ## 创建合成配置
     *
     * @param connectionId uuid
     */
    private fun createSynthesisContext(connectionId: String) =
        SpeechRequest(SpeechRequest.Path.SynthesisContext, connectionId, JSON, json.encodeToString(SynthesisContext())).toString()

    /**
     * ## 创建ssml配置
     *
     */
    private fun createSSML(connectionId: String, ssml: String) = SpeechRequest(SpeechRequest.Path.SSML, connectionId, SSML_XML, ssml).toString()


    /**
     * ## 创建 id
     *
     */
    private fun createID() = UUID.randomUUID().toString().replace("-", "").uppercase()

}

object TTS {

    private val tts by lazy { TextToSpeech() }

    /**
     * ## 文字转语音
     *
     * @param ssml ssml格式内容
     */
    suspend fun convert(ssml: String): ByteArray = tts.convert(ssml)
}
