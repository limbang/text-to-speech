/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.neural.zh_cn

import top.limbang.neural.Gender
import top.limbang.ssml.Style

/**
 * ## 晓晓
 *
 * 支持以下风格
 * - 0 -> [Style.General]
 * - 1 -> [Style.Assistant]
 * - 2 -> [Style.Chat]
 * - 3 -> [Style.CustomerService]
 * - 4 -> [Style.Newscast]
 * - 5 -> [Style.Affectionate]
 * - 6 -> [Style.Angry]
 * - 7 -> [Style.Calm]
 * - 8 -> [Style.Cheerful]
 * - 9 -> [Style.Disgruntled]
 * - 10 -> [Style.Fearful]
 * - 11 -> [Style.Gentle]
 * - 12 -> [Style.Lyrical]
 * - 13 -> [Style.Sad]
 * - 14 -> [Style.Serious]
 * - 15 -> [Style.PoetryReading]
 *
 */
class XiaoxiaoNeural : MandarinSimplifiedNeural {
    override val name = "zh-CN-XiaoxiaoNeural"
    override val localName = "晓晓"
    override val gender = Gender.Female
    override val styleList = listOf(
        Style.General, Style.Assistant, Style.Chat, Style.CustomerService, Style.Newscast, Style.Affectionate, Style.Angry,
        Style.Calm, Style.Cheerful, Style.Disgruntled, Style.Fearful, Style.Gentle, Style.Lyrical, Style.Sad, Style.Serious, Style.PoetryReading
    )
}