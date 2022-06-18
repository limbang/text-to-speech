/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.tts.entity

import kotlinx.serialization.Serializable

/**
 * ## 语音配置
 *
 */
@Serializable
data class SpeechConfig(val context: Context = Context()) {
    @Serializable
    data class Context(
        val system: System = System(),
        val os: Os = Os()
    ) {
        @Serializable
        data class System(
            val name: String = "SpeechSDK",
            val version: String = "1.19.0",
            val build: String = "JavaScript",
            val lang: String = "JavaScript"
        )
        @Serializable
        data class Os(
            val platform: String = "Browser/Win32",
            val name: String = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.63 Mobile Safari/537.36",
            val version: String = "5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.63 Mobile Safari/537.36"
        )
    }
}

