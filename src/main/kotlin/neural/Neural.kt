/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.tts.neural

import top.limbang.tts.ssml.Role
import top.limbang.tts.ssml.Style

/**
 * 预生成的神经语音接口
 *
 */
interface Neural {

    /** 语音名称 */
    val name: String

    /** 本地名称 */
    val localName: String

    /** 性别 */
    val gender: Gender

    /** 地区 */
    val locale: Region

    /** 支持的风格列表 */
    val styleList: List<Style>
        get() = listOf(Style.General)

    /** 支持的角色列表 */
    val roleList: List<Role>
        get() = listOf(Role.Default)

}