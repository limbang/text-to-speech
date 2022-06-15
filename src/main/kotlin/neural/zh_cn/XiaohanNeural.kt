/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.neural.zh_cn

import top.limbang.neural.Gender
import top.limbang.ssml.Role
import top.limbang.ssml.Style

/**
 * ## 晓涵
 *
 * 支持以下风格
 * - 0 -> [Style.General]
 * - 1 -> [Style.Calm]
 * - 2 -> [Style.Fearful]
 * - 3 -> [Style.Disgruntled]
 * - 4 -> [Style.Serious]
 * - 5 -> [Style.Angry]
 * - 6 -> [Style.Sad]
 * - 7 -> [Style.Gentle]
 * - 8 -> [Style.Affectionate]
 * - 9 -> [Style.Embarrassed]
 *
 */
class XiaohanNeural : MandarinSimplifiedNeural {

    override val name = "zh-cn-XiaohanNeural"
    override val gender = Gender.Female
    override val styleList = listOf(
        Style.General, Style.Calm, Style.Fearful, Style.Disgruntled, Style.Serious, Style.Angry, Style.Sad, Style.Gentle,
        Style.Affectionate, Style.Embarrassed
    )
    override val roleList = listOf(Role.Default)
}