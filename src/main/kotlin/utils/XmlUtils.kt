/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.utils

import javax.xml.stream.XMLStreamWriter

fun XMLStreamWriter.document(init: XMLStreamWriter.() -> Unit): XMLStreamWriter {
    this.writeStartDocument()
    this.init()
    this.writeEndDocument()
    return this
}

fun XMLStreamWriter.element(name: String, init: XMLStreamWriter.() -> Unit): XMLStreamWriter {
    this.writeStartElement(name)
    this.init()
    this.writeEndElement()
    return this
}

fun XMLStreamWriter.emptyElement(name: String): XMLStreamWriter {
    this.writeEmptyElement(name)
    return this
}


fun XMLStreamWriter.attribute(name: String, value: String) = writeAttribute(name, value)