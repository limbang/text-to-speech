/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.tts.neural.zh_cn

import top.limbang.tts.neural.Gender
import top.limbang.tts.ssml.Role
import top.limbang.tts.ssml.Style

/**
 * ## 云希
 *
 * ### 支持以下风格
 * - 0 -> [Style.General]
 * - 1 -> [Style.NarrationRelaxed]
 * - 2 -> [Style.Embarrassed]
 * - 3 -> [Style.Fearful]
 * - 4 -> [Style.Cheerful]
 * - 5 -> [Style.Disgruntled]
 * - 6 -> [Style.Serious]
 * - 7 -> [Style.Angry]
 * - 8 -> [Style.Sad]
 * - 9 -> [Style.Depressed]
 * - 10 -> [Style.Chat]
 * - 11 -> [Style.Assistant]
 * - 12 -> [Style.Newscast]
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
class YunxiNeural : MandarinSimplifiedNeural{
    override val name = "zh-CN-YunxiNeural"
    override val localName = "云希"
    override val gender = Gender.Male
    override val styleList = listOf(
        Style.General, Style.NarrationRelaxed, Style.Embarrassed, Style.Fearful, Style.Cheerful, Style.Disgruntled,
        Style.Serious, Style.Angry, Style.Sad, Style.Depressed, Style.Chat, Style.Assistant, Style.Newscast
    )
    override val roleList = listOf(
        Role.Default, Role.YoungAdultFemale, Role.YoungAdultMale, Role.OlderAdultFemale, Role.OlderAdultMale,
        Role.SeniorFemale, Role.SeniorMale, Role.Girl, Role.Boy
    )
}