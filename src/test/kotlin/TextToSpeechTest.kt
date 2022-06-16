/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import top.limbang.neural.zh_cn.XiaochenNeural
import top.limbang.ssml.*
import java.io.FileOutputStream
import kotlin.test.Test

class TextToSpeechTest {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @Test
    fun textToSpeechTest() {
        val xiaoche = XiaochenNeural()

        val ssml = Speak {
            voice(xiaoche.name, "你好！"){
                adjustSpeakingStyles {
                    prosody(rate = 150,text = it)
                }
                `break`()
                adjustSpeakingStyles(text = "我是晓晓")
                silence("Sentenceboundary","100ms")
                prosody(text = "1+1=2")
            }
        }

        val logInterceptor = HttpLoggingInterceptor { message -> logger.debug(message) }
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)

        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(logInterceptor)
            .build()

        val textToSpeech = TextToSpeech(client)
        val out = FileOutputStream("123.mp3")

        runBlocking {
            val mp3 = textToSpeech.convert(ssml)
            if (mp3.isNotEmpty()) withContext(Dispatchers.IO) {
                out.write(mp3)
                out.flush()
                out.close()
            }
        }

    }


}