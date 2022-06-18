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
 * ## 云枫
 *
 * ### 支持以下风格
 * - 0 -> [Style.General]
 * - 1 -> [Style.Angry]
 * - 2 -> [Style.Disgruntled]
 * - 3 -> [Style.Cheerful]
 * - 4 -> [Style.Fearful]
 * - 5 -> [Style.Sad]
 * - 6 -> [Style.Serious]
 * - 7 -> [Style.Depressed]
 */
class YunfengNeural : MandarinSimplifiedNeural {
    override val name = "zh-CN-YunfengNeural"
    override val localName = "云枫"
    override val gender = Gender.Male
    override val styleList = listOf(
        Style.General,Style.Angry,Style.Depressed,Style.Cheerful,Style.Fearful, Style.Sad,Style.Serious,Style.Depressed
    )
}