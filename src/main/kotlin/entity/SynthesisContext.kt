/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.entity

import kotlinx.serialization.Serializable

/**
 * 合成配置
 */
@Serializable
data class SynthesisContext(var synthesis: Synthesis = Synthesis()) {
    @Serializable
    data class Synthesis(
        var audio: Audio = Audio(),
        var language: Language = Language()
    ) {
        @Serializable
        data class Audio(
            var metadataOptions: MetadataOptions = MetadataOptions(),
            var outputFormat: String = "audio-24khz-160kbitrate-mono-mp3"
        ) {
            @Serializable
            data class MetadataOptions(
                var bookmarkEnabled: Boolean = false,
                var sentenceBoundaryEnabled: Boolean = false,
                var visemeEnabled: Boolean = false,
                var wordBoundaryEnabled: Boolean = false
            )
        }

        @Serializable
        data class Language(var autoDetection: Boolean = false)
    }
}