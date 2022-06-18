<div align="center">

[![](https://img.shields.io/github/v/release/limbang/text-to-speech?include_prereleases)](https://github.com/limbang/mirai-console-rcon-plugin/releases)
[![](https://img.shields.io/github/license/limbang/mirai-console-rcon-plugin)](https://github.com/limbang/mirai-console-rcon-plugin/blob/master/LICENSE)


本项目是基于 <a href = "https://azure.microsoft.com/zh-cn/services/cognitive-services/text-to-speech/">Azure 文本转语音服务 </a> 实现
</div>

# 使用方法: 参考[SSML语法](https://docs.microsoft.com/zh-cn/azure/cognitive-services/speech-service/speech-synthesis-markup?tabs=csharp)
```kotlin
val ssml = createSSML().speak{
    voice(XiaoxiaoNeural()) {
        +"你好我是${it.localName}"
    }
}

val out = FileOutputStream("123.mp3")

runBlocking {
    // 需要在协程里面执行
    val speech = TTS.convert(ssml)
    if (speech.isNotEmpty()) withContext(Dispatchers.IO) {
        out.write(speech)
        out.flush()
        out.close()
    }
}

```
