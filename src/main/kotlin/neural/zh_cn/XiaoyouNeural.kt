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
 * ## 晓悠
 * 儿童语音，针对讲故事进行了优化
 */
class XiaoyouNeural : MandarinSimplifiedNeural {

    override val name = "zh-cn-XiaoyouNeural"
    override val gender = Gender.Female
    override val styleList = listOf(Style.General)
    override val roleList = listOf(Role.Default)
}
