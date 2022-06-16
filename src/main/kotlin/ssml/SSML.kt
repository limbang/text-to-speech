/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.ssml

import top.limbang.neural.Region
import top.limbang.utils.attribute
import top.limbang.utils.element
import java.io.ByteArrayOutputStream
import javax.xml.stream.XMLOutputFactory
import javax.xml.stream.XMLStreamWriter

/**
 * 创建一个文字转语音的 SSML 文本
 *
 * @param version 指示用于解释文档标记的 SSML 规范的版本。 当前版本为 1.0。
 * @param lang 指定根文档的语言。 可以包含两个小写字母的语言代码，例如 en。 或者值也可以包含语言代码和大写的国家/地区，例如 en-US。
 * @param action 添加语音
 */
class Speak(version: String = "1.0", lang: String = Region.English_UnitedStates.value, action: Speak.() -> Unit) {

    private val bos = ByteArrayOutputStream()
    val writer: XMLStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(bos)

    init {
        writer.element("speak") {
            attribute("xmlns", "http://www.w3.org/2001/10/synthesis")
            attribute("xmlns:mstts", "http://www.w3.org/2001/mstts")
            attribute("xmlns:emo", "http://www.w3.org/2009/10/emotionml")
            attribute("version", version)
            attribute("xml:lang", lang)
            action()
        }
    }

    /**
     * 把 Speak 转成 ssml 文本
     */
    override fun toString(): String {
        writer.flush()
        writer.close()
        return bos.toString()
    }

}

/**
 * 用来限制扩展函数 adjustSpeakingStyles 只能在 voice 里面创建
 */
class Voice(val speak: Speak)

/**
 * 添加一个语音
 *
 * @param name 标识用于文本转语音输出的语音。
 * @param text 要转换成语音的内容
 */
fun Speak.voice(name: String, text: String = "", action: (Voice.(String) -> Unit)? = null) {
    writer.element("voice") {
        attribute("name", name)
        if (text.isNotEmpty()) writeCharacters(text)
        if (action != null) Voice(this@voice).action(text)
    }
}

/**
 * ## 调整讲话风格
 * 默认情况下，对于神经语音，文本转语音使用中性讲话风格来合成文本。 可在句子层面调整讲话风格、风格强度和角色。
 * 部分神经语音支持风格、风格强度和角色。 如果某种风格或角色不受支持，该服务将使用默认的中性语言。
 * @param style 指定讲话风格。 说话风格特定于语音。
 * @param styleDegree 指定说话风格的强度。 接受的值：0.01 到 2（含边界值）。 默认值为 1，表示预定义的风格强度。 最小单位为 0.01，表示略倾向于目标风格。 值为 2 表示是默认风格强度的两倍。
 * @param role 指定讲话角色扮演。 语音充当不同的年龄和性别，但语音名称不会更改。
 * @param text 要转换成语音的内容
 */
fun Voice.adjustSpeakingStyles(style: Style = Style.General, styleDegree: Double = 1.0, role: Role = Role.Default, text: String, action: (Voice.() -> Unit)? = null) {
    // 如果文本为空就不处理
    if(text.isEmpty()) return
    // 如果风格和角色都是默认的那么就去掉 mstts:express-as 节点，直接输入文本
    if (style == Style.General && role == Role.Default) {
        if (text.isNotEmpty()) speak.writer.writeCharacters(text)
        return
    }
    // 设置说话风格和角色
    speak.writer.element("mstts:express-as") {
        if (style != Style.General) attribute("style", style.value)
        if (style != Style.General) attribute("styledegree", if (styleDegree > 2 || styleDegree < 0.01) "1" else styleDegree.toString())
        if (role != Role.Default) attribute("role", role.name)
        if (action != null ) action() else writeCharacters(text)
    }
}

/**
 * 语速和音调
 *
 * @param rate 语速 -100 到 200
 * @param pitch 音调  -50 到 50
 */
fun Voice.prosody(rate: Int = 0, pitch: Int = 0, text: String) {
    if(text.isEmpty()) return
    speak.writer.element("prosody") {
        attribute("rate", "${if (rate < -100 || rate > 200) 0 else rate}%")
        attribute("pitch", "${if (pitch < -50 || pitch > 50) 0 else pitch}%")
        writeCharacters(text)
    }
}