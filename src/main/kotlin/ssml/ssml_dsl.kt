/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.tts.ssml

import top.limbang.tts.neural.Neural
import top.limbang.tts.neural.Region

/**
 * ## 以DSL方式创建一个文字转语音的 SSML 文本
 * 可以参考 [通过语音合成标记语言 (SSML) 改善合成](https://docs.microsoft.com/zh-cn/azure/cognitive-services/speech-service/speech-synthesis-markup?tabs=csharp)
 *
 * 例子：创建晓晓神经语音以默认的方式生成你好
 * ```
 *  createSSML().speak {
 *      voice(XiaoxiaoNeural()) {
 *          +"你好"
 *      }
 *  }
 * ```
 */
typealias createSSML = SSMLBuilder

class SSMLBuilder {
    /**
     * ## 创建 speak 元素
     * - [Speak.version]
     * - [Speak.lang]
     */
    fun speak(init: Speak.() -> Unit): Speak {
        val speak = Speak()
        speak.init()
        return speak
    }
}

class Speak : Tag("speak") {

    /**
     * ## 指示用于解释文档标记的 SSML 规范的版本。
     * 默认为: 1.0
     */
    var version: String
        get() = attributes["version"] ?: "1.0"
        set(value) {
            attributes["version"] = value
        }

    /**
     * ## 指定根文档的语言。
     * 可以包含两个小写字母的语言代码，例如 en。 或者值也可以包含语言代码和大写的国家/地区，例如 en-US。
     * 默认为: [Region.English_UnitedStates.value]
     */
    var lang: String
        get() = attributes["xml:lang"] ?: Region.English_UnitedStates.value
        set(value) {
            attributes["xml:lang"] = value
        }

    init {
        attributes["xmlns"] = "http://www.w3.org/2001/10/synthesis"
        attributes["xmlns:mstts"] = "http://www.w3.org/2001/mstts"
        attributes["xmlns:emo"] = "http://www.w3.org/2009/10/emotionml"
        attributes["version"] = version
        attributes["xml:lang"] = lang
    }

    /**
     * ## 创建 voice 元素
     *
     * @param neural 神经语音
     */
    fun voice(neural: Neural, init: Voice.(Neural) -> Unit): Voice {
        val tag = Voice(neural)
        tag.init(neural)
        children.add(tag)
        return tag
    }
}

abstract class VoiceTag(name: String) : TagWithText(name) {

    /**
     * ## 调整讲话风格
     * 默认情况下，对于神经语音，文本转语音使用中性讲话风格来合成文本。 可在句子层面调整讲话风格、风格强度和角色。
     * 部分神经语音支持风格、风格强度和角色。 如果某种风格或角色不受支持，该服务将使用默认的中性语言。
     * - [AdjustSpeakingStyles.style]
     * - [AdjustSpeakingStyles.styleDegree]
     * - [AdjustSpeakingStyles.role]
     */
    fun adjustSpeakingStyles(init: AdjustSpeakingStyles.() -> Unit) = initTag(AdjustSpeakingStyles(), init)


    /**
     * ## 添加或删除中断或暂停
     * 可在单词之间插入停顿或中断。 还可使用它来防止文本转语音自动添加的暂停。
     *
     * @param strength 使用以下值之一指定暂停的相对持续时间：
     * - None，或者不提供任何值 -> 0 毫秒
     * - x-weak -> 250 毫秒
     * - weak -> 500 毫秒
     * - strong -> 750 毫秒  (默认值)
     * - medium -> 1,000 毫秒
     * - x-strong -> 1,250毫秒
     * @param time 指定暂停的绝对持续时间，以秒或毫秒 (ms) 为单位。 应将此值设置为小于 5000 毫秒。 例如，2s 和 500ms 是有效值。
     */
    fun `break`(strength: String = "strong", time: String = "") = initTag(Break(strength, time))

    /**
     * ## 添加静音
     * [silence] 和 [break] 之间的区别在于，[break] 可添加到文本中的任何位置。 静音仅适用于输入文本的开头或结尾，或者两个相邻句子的分界处。
     *
     * @param type 指定添加静音的位置：
     * - Leading - 在文本的开头
     * - Tailing - 在文本的结尾
     * - Sentenceboundary - 在相邻句子之间
     * @param value 指定暂停的绝对持续时间，以秒或毫秒为单位。 应将此值设置为小于 5000 毫秒。 例如，2s 和 500ms 是有效值。
     */
    fun silence(type: String, value: String) = initTag(Silence(type,value))

    /**
     * ## 指定段落
     * p 元素可包含文本和以下元素：audio、break、phoneme、prosody、say-as、sub、mstts:express-as 和 s
     */
    fun p(init: P.() -> Unit) = initTag(P(), init)

    /**
     * ## 调整韵律
     * prosody 元素用于指定文本转语音输出的音节、调型、范围、速率和音量的变化。 prosody 元素可包含文本和以下元素：audio、break、p、phoneme、prosody、say-as、sub 和 s。
     * 由于韵律属性值可在较大范围内变化，因此，语音识别器会将分配的值解释为所选语音的建议实际韵律值。 文本转语音将限制或替代不支持的值。 例如，音节 1 MHz 或音量 120 就是不支持的值。
     * - [Prosody.pitch]
     * - [Prosody.contour]
     * - [Prosody.range]
     * - [Prosody.rate]
     * - [Prosody.volume]
     */
    fun prosody(init: Prosody.() -> Unit) = initTag(Prosody(), init)
}

class Voice(neural: Neural) : VoiceTag("voice") {
    init {
        attributes["name"] = neural.name
    }
}

class AdjustSpeakingStyles : VoiceTag("mstts:express-as") {
    /**
     * ## 指定讲话风格
     * 默认为:[Style.General]
     */
    var style: Style
        get() = Style.fromValue(attributes["style"] ?: Style.General.value)
        set(value) {
            attributes["style"] = value.value
        }

    /**
     * ## 指定风格强度
     * 接受的值：0.01 到 2（含边界值）。
     * 默认值为 1，表示预定义的风格强度。
     * 最小单位为 0.01，表示略倾向于目标风格。
     * 值为 2 表示是默认风格强度的两倍。
     */
    var styleDegree: Double
        get() = attributes["styledegree"]?.toDouble() ?: 1.0
        set(value) {
            attributes["styledegree"] = value.toString()
        }

    /**
     * ## 指定讲话角色扮演
     * 语音充当不同的年龄和性别，但语音名称不会更改。
     * 默认为:[Role.Default]
     */
    var role: Role
        get() = Role.valueOf(attributes["role"] ?: Role.Default.name)
        set(value) {
            attributes["role"] = value.name
        }

    init {
        if (style != Style.General) attributes["style"] = style.value
        if (style != Style.General) attributes["styledegree"] = if (styleDegree > 2 || styleDegree < 0.01) "1" else styleDegree.toString()
        if (role != Role.Default) attributes["role"] = role.name
    }
}


class Break(strength: String, time: String) : EmptyTag("break") {
    init {
        if (time.isEmpty()) attributes["strength"] = strength else attributes["time"] = time
    }
}

class Silence(type: String, value: String) : EmptyTag("mstts:silence") {
    init {
        attributes["type"] = type
        attributes["value"] = value
    }
}

class P : VoiceTag("p"){
    /**
     * ## 指定句子
     * s 元素可包含文本和以下元素：audio、break、phoneme、prosody、say-as、mstts:express-as 和 sub。
     */
    fun s(init: S.() -> Unit) = initTag(S(), init)
}

class S : VoiceTag("s")

class Prosody : VoiceTag("prosody"){
    /**
     * ## 指示文本的基线音节
     * - 以某个数字后接“Hz”（赫兹）表示的绝对值。 例如，<prosody pitch="600Hz">some text</prosody> 。
     * - 以前面带有“+”或“-”的数字，后接“Hz”或“st”（用于指定音节的变化量）表示的相对值。 例如 <prosody pitch="+80Hz">some text</prosody> 或 <prosody pitch="-2st">some text</prosody>。 “st”表示变化单位为半音，即，标准全音阶中的半调（半步）。
     * - 常量值：
     *      - x-low
     *      - low
     *      - medium
     *      - high
     *      - x-high
     *      - default
     */
    var pitch : String
        get() = attributes["pitch"] ?: ""
        set(value) {
            attributes["pitch"] = value
        }

    /**
     * ## Contour 现支持神经语音。 调型表示音节的变化。
     * 这些变化以语音输出中指定时间处的目标数组形式表示。 每个目标由参数对的集定义。例如：
     * ```
     * <prosody contour="(0%,+20Hz) (10%,-2st) (40%,+10Hz)">
     * ```
     * 每参数集中的第一个值以文本持续时间百分比的形式指定音节变化的位置。 第二个值使用音节的相对值或枚举值指定音节的升高或降低量（请参阅 pitch）。
     */
    var contour : String
        get() = attributes["contour"] ?: ""
        set(value) {
            attributes["contour"] = value
        }

    /**
     * ## 表示文本音节范围的值。
     * 可使用用于描述 pitch 的相同绝对值、相对值或枚举值表示 range。
     */
    var range : String
        get() = attributes["range"] ?: ""
        set(value) {
            attributes["range"] = value
        }

    /**
     * ## 指示文本的讲出速率。
     * 可将 rate 表述为：
     * - 以充当默认值倍数的数字表示的相对值。 例如，如果值为 1，则速率不会变化。 如果值为 0.5，则速率会减慢一半。 如果值为 3，则速率为三倍。
     * - 常量值：
     *      - x-slow
     *      - slow
     *      - medium
     *      - fast
     *      - x-fast
     *      - default
     */
    var rate : String
        get() = attributes["rate"] ?: ""
        set(value) {
            attributes["rate"] = value
        }

    /**
     * ## 指示语音的音量级别。
     * 可将音量表示为：
     * - 以从 0.0 到 100.0（从最安静到最大声）的数字表示的绝对值。 例如 75。 默认值为 100.0。
     * - 以前面带有“+”或“-”的数字表示的相对值，指定音量的变化量。 例如 +10 或 -5.5。
     * - 常量值：
     *      - silent
     *      - x-soft
     *      - soft
     *      - medium
     *      - loud
     *      - x-loud
     *      - default
     */
    var volume : String
        get() = attributes["volume"] ?: ""
        set(value) {
            attributes["volume"] = value
        }

    init {
        if(pitch.isNotEmpty())  attributes["pitch"] = pitch
        if(contour.isNotEmpty())  attributes["contour"] = contour
        if(range.isNotEmpty())  attributes["range"] = range
        if(rate.isNotEmpty())  attributes["rate"] = rate
        if(volume.isNotEmpty())  attributes["volume"] = volume
    }
}