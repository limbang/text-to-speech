/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.tts.neural.zh_cn

import top.limbang.tts.neural.Gender

/**
 * ## 晓悠
 * 儿童语音，针对讲故事进行了优化
 */
class XiaoyouNeural : MandarinSimplifiedNeural {
    override val name = "zh-CN-XiaoyouNeural"
    override val localName = "晓悠"
    override val gender = Gender.Female
}
