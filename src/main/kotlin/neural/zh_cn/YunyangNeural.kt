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
 * ## 云扬
 * 针对新闻阅读进行了优化，
 *
 * ### 支持以下风格
 * - 0 -> [Style.General]
 * - 1 -> [Style.CustomerService]
 * - 2 -> [Style.NarrationProfessional]
 * - 3 -> [Style.NewscastCasual]
 *
 */
class YunyangNeural  : MandarinSimplifiedNeural{
    override val name = "zh-CN-YunyangNeural"
    override val localName = "云扬"
    override val gender = Gender.Male
    override val styleList = listOf(Style.General, Style.CustomerService, Style.NarrationProfessional, Style.NewscastCasual)
}