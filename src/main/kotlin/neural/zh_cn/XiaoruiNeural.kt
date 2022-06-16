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
 * ## 晓睿
 * 高级语音，使用 SSML 提供多种风格
 *
 * 支持以下风格
 * - 0 -> [Style.General]
 * - 1 -> [Style.Calm]
 * - 2 -> [Style.Fearful]
 * - 3 -> [Style.Angry]
 * - 4 -> [Style.Sad]
 */
class XiaoruiNeural : MandarinSimplifiedNeural {
    override val name = "zh-CN-XiaoruiNeural"
    override val localName = "晓睿"
    override val gender = Gender.Female
    override val styleList = listOf(Style.General, Style.Calm, Style.Fearful, Style.Angry, Style.Sad)
}