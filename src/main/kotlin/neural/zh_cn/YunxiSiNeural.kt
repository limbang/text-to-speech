/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.tts.neural.zh_cn

import top.limbang.tts.neural.Gender

/**
 * ## 云希四川
 */
class YunxiSiNeural: MandarinSimplifiedNeural {
    override val name = "zh-CN-SC-YunxiNeural"
    override val localName = "云希四川"
    override val gender = Gender.Male
}