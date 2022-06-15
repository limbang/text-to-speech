/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.entity

import top.limbang.entity.SpeechRequest.ContentType
import top.limbang.entity.SpeechRequest.ContentType.JSON
import top.limbang.entity.SpeechRequest.ContentType.SSML_XML
import top.limbang.entity.SpeechRequest.Path
import top.limbang.entity.SpeechRequest.Path.*
import top.limbang.entity.SpeechRequest.Path.SpeechConfig
import top.limbang.entity.SpeechRequest.Path.SynthesisContext
import java.time.Instant

/**
 * 语音 WebSocket 请求
 *
 * @property path 参考 [Path]
 * @property requestId uuid
 * @property contentType 参考 [ContentType]
 * @property data 请求内容
 */
class SpeechRequest(private val path: Path, private val requestId: String, private val contentType: ContentType, private val data: String) {

    /**
     * Path
     *
     * - [SpeechConfig] 语音配置
     * - [SynthesisContext] 输出配置
     * - [SSML] ssml 配置
     */
    enum class Path(val value: String) {
        SpeechConfig("speech.config"),
        SynthesisContext("synthesis.context"),
        SSML("ssml")
    }

    /**
     * 内容标签
     *
     * - [JSON] json
     * - [SSML_XML] ssml+xml
     */
    enum class ContentType(val value: String) {
        JSON("json"),
        SSML_XML("ssml+xml")
    }

    override fun toString(): String {
        return "Path: ${path.value}\r\nX-RequestId: $requestId\r\nX-Timestamp: ${Instant.now()}\r\nContent-Type: application/${contentType.value}\r\n\r\n$data"
    }
}