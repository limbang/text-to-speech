/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.neural.zh_cn

import top.limbang.neural.Gender

/**
 * ## 晓晨
 * 针对自发对话进行了优化
 */
class XiaochenNeural : MandarinSimplifiedNeural {
    override val name = "zh-CN-XiaochenNeural"
    override val localName = "晓晨"
    override val gender = Gender.Female
}