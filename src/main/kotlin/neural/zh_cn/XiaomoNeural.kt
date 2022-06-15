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
 * ## 晓墨
 *
 * ### 支持以下风格
 * - 0 -> [Style.General]
 * - 1 -> [Style.Embarrassed]
 * - 2 -> [Style.Calm]
 * - 3 -> [Style.Fearful]
 * - 4 -> [Style.Cheerful]
 * - 5 -> [Style.Disgruntled]
 * - 6 -> [Style.Serious]
 * - 7 -> [Style.Angry]
 * - 8 -> [Style.Sad]
 * - 9 -> [Style.Depressed]
 * - 10 -> [Style.Affectionate]
 * - 11 -> [Style.Gentle]
 * - 12 -> [Style.Envious]
 *
 * ### 支持以下角色
 * - 0 -> [Role.Default]
 * - 1 -> [Role.YoungAdultFemale]
 * - 2 -> [Role.YoungAdultMale]
 * - 3 -> [Role.OlderAdultFemale]
 * - 4 -> [Role.OlderAdultMale]
 * - 5 -> [Role.SeniorFemale]
 * - 6 -> [Role.SeniorMale]
 * - 7 -> [Role.Girl]
 * - 8 -> [Role.Boy]
 */
class XiaomoNeural : MandarinSimplifiedNeural {

    override val name = "zh-cn-XiaomoNeural"
    override val gender = Gender.Female
    override val styleList = listOf(
        Style.General, Style.Embarrassed, Style.Calm, Style.Fearful, Style.Cheerful, Style.Disgruntled, Style.Serious,
        Style.Angry, Style.Sad, Style.Depressed, Style.Affectionate, Style.Gentle, Style.Envious
    )
    override val roleList = listOf(
        Role.Default, Role.YoungAdultFemale, Role.YoungAdultMale, Role.OlderAdultFemale, Role.OlderAdultMale,
        Role.SeniorFemale, Role.SeniorMale, Role.Girl, Role.Boy
    )
}
