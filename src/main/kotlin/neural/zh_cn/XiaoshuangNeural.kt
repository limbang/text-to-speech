/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.tts.neural.zh_cn

import top.limbang.tts.neural.Gender
import top.limbang.tts.ssml.Style

/**
 * ## 晓双
 * 儿童语音，针对儿童故事和聊天进行了优化；使用 SSML 提供多种语音风格
 *
 * 支持以下风格
 * - 0 -> [Style.General]
 * - 1 -> [Style.Chat]
 */
class XiaoshuangNeural : MandarinSimplifiedNeural {
    override val name = "zh-CN-XiaoshuangNeural"
    override val localName = "晓双"
    override val gender = Gender.Female
    override val styleList = listOf(Style.General, Style.Chat)
}
