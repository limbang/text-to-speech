/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.tts.ssml

/**
 * ## 元素接口
 */
interface Element {
    /**
     * ## 渲染元素
     */
    fun render(builder: StringBuilder)
}

/**
 * ## 文本元素
 *
 * @property text 内容
 */
class TextElement(val text: String) : Element {
    override fun render(builder: StringBuilder) {
        builder.append("$text")
    }
}

@DslMarker
annotation class SsmlTagMarker

@SsmlTagMarker
abstract class Tag(val name: String) : Element {
    /**
     * ## 存放元素
     */
    val children = arrayListOf<Element>()

    /**
     * ## 存放属性
     */
    val attributes = hashMapOf<String, String>()

    /**
     * ## 初始化标签
     *
     * @param tag 标签
     * @param init 初始化函数
     */
    protected fun <T : Element> initTag(tag: T, init: T.() -> Unit): T {
        tag.init()
        return initTag(tag)
    }

    /**
     * ## 初始化标签
     *
     * @param tag 标签
     */
    protected fun <T : Element> initTag(tag: T): T {
        children.add(tag)
        return tag
    }

    override fun render(builder: StringBuilder) {
        builder.append("<$name${attributes.renderAttributes()}>")
        for (c in children) {
            c.render(builder)
        }
        builder.append("</$name>")
    }

    /**
     * ## 转换成 ssml 文本
     */
    override fun toString(): String {
        val builder = StringBuilder()
        render(builder)
        return builder.toString()
    }

    /**
     * ## 渲染属性
     *
     */
    internal fun HashMap<String, String>.renderAttributes(): String {
        val builder = StringBuilder()
        for ((attr, value) in this) {
            builder.append(" $attr=\"$value\"")
        }
        return builder.toString()
    }
}

/**
 * ## 带文本的标签
 * 可以使用
 * ```
 * +"字符串"
 * ```
 */
abstract class TagWithText(name: String) : Tag(name) {
    operator fun String.unaryPlus() {
        children.add(TextElement(this))
    }
}

/**
 * ## 空标签
 * ```
 * <break strength="string" />
 * <break time="string" />
 * ```
 */
abstract class EmptyTag(name: String) : Tag(name) {
    override fun render(builder: StringBuilder) {
        builder.append("<$name${attributes.renderAttributes()}")
        for (c in children) {
            c.render(builder)
        }
        builder.append(" />")
    }
}
