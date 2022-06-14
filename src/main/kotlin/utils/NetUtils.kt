/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.utils

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import java.util.concurrent.TimeUnit


object NetUtils {

    private val client = OkHttpClient.Builder()
        .readTimeout(3, TimeUnit.SECONDS)
        .writeTimeout(3, TimeUnit.SECONDS)
        .connectTimeout(3, TimeUnit.SECONDS)
        .build()

    fun get(url: String): String {
        val request = Request.Builder().url(url).build()
        return client.newCall(request).execute().body!!.string()
    }

    fun createWebSocket(url: String, webSocketHandler: WebSocketListener): WebSocket {
        val request = Request.Builder().url(url).build()
        return client.newWebSocket(request, webSocketHandler)
    }

}