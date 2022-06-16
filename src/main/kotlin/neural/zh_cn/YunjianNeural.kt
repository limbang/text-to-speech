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
 * ## 云健 (预览)
 *
 * 体育播报解说优化
 *
 * ### 支持以下风格
 * - 0 -> [Style.General]
 * - 1 -> [Style.NarrationRelaxed]
 * - 2 -> [Style.SportsCommentary]
 * - 3 -> [Style.SportsCommentaryExcited]
 */
class YunjianNeural : MandarinSimplifiedNeural {
    override val name = "zh-CN-YunjianNeural"
    override val localName = "云健"
    override val gender = Gender.Male
    override val styleList = listOf(Style.General, Style.NarrationRelaxed,Style.SportsCommentary,Style.SportsCommentaryExcited)
}