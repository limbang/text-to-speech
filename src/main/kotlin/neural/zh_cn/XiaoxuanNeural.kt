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
 * ## 晓萱
 *
 * 支持以下风格
 * - 0 -> [Style.General]
 * - 1 -> [Style.Calm]
 * - 2 -> [Style.Fearful]
 * - 3 -> [Style.Cheerful]
 * - 4 -> [Style.Disgruntled]
 * - 5 -> [Style.Serious]
 * - 6 -> [Style.Angry]
 * - 7 -> [Style.Gentle]
 * - 8 -> [Style.Depressed]
 */
class XiaoxuanNeural : MandarinSimplifiedNeural {

    override val name = "zh-cn-XiaoxuanNeural"
    override val gender = Gender.Female
    override val styleList = listOf(
        Style.General, Style.Calm, Style.Fearful, Style.Cheerful, Style.Disgruntled, Style.Serious,
        Style.Angry, Style.Gentle, Style.Depressed
    )
    override val roleList = listOf(
        Role.Default, Role.YoungAdultFemale, Role.YoungAdultMale, Role.OlderAdultFemale, Role.OlderAdultMale,
        Role.SeniorFemale, Role.SeniorMale, Role.Girl, Role.Boy
    )
}
