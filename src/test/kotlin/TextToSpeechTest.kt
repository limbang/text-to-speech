/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.tts

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import top.limbang.tts.neural.zh_cn.XiaoxiaoNeural
import top.limbang.tts.ssml.createSSML
import java.io.FileOutputStream

class TextToSpeechTest {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @Test
    fun textToSpeechTest() {
        val ssml = createSSML().speak {
            voice(XiaoxiaoNeural()) {
                adjustSpeakingStyles {
                    // 悲伤的语气
                    style = it.styleList[13]
                    +"你好我是"
                    // 暂停 250毫秒
                    `break`("x-weak")
                    // 说出名字
                    +it.localName
                    p {
                        s {
                            +"这是一句话"
                        }
                        s {
                            prosody {
                                rate = "+30.00%"
                                +"这是一句加速的话"
                            }
                        }
                        s {
                            prosody {
                                pitch = "high"
                                +"这是一句提高音高的话"
                            }
                            `break`(time = "100ms")
                            prosody {
                                contour = "(60%,-60%) (100%,+80%)"
                                +"这是一句更改音高升降曲线的话"
                            }
                        }
                    }
                }
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
            val mp3 = textToSpeech.convert(ssml.toString())
            if (mp3.isNotEmpty()) withContext(Dispatchers.IO) {
                out.write(mp3)
                out.flush()
                out.close()
            }
        }

    }
}