/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.tts.entity

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
        /**
         * Audio
         *
         * [outputFormat] 支持以下:
         * ```
         * raw-16khz-16bit-mono-pcm            riff-16khz-16bit-mono-pcm
         * raw-24khz-16bit-mono-pcm            riff-24khz-16bit-mono-pcm
         * raw-48khz-16bit-mono-pcm            riff-48khz-16bit-mono-pcm
         * raw-8khz-8bit-mono-mulaw            riff-8khz-8bit-mono-mulaw
         * raw-8khz-8bit-mono-alaw             riff-8khz-8bit-mono-alaw
         * audio-16khz-32kbitrate-mono-mp3     audio-16khz-64kbitrate-mono-mp3
         * audio-16khz-128kbitrate-mono-mp3    audio-24khz-48kbitrate-mono-mp3
         * audio-24khz-96kbitrate-mono-mp3     audio-24khz-160kbitrate-mono-mp3
         * audio-48khz-96kbitrate-mono-mp3     audio-48khz-192kbitrate-mono-mp3
         * raw-16khz-16bit-mono-truesilk       raw-24khz-16bit-mono-truesilk
         * webm-16khz-16bit-mono-opus          webm-24khz-16bit-mono-opus
         * ogg-16khz-16bit-mono-opus           ogg-24khz-16bit-mono-opus
         * ogg-48khz-16bit-mono-opus
         * ```
         */
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