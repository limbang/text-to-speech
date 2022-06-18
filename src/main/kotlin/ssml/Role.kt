/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.tts.ssml

/**
 * 角色
 *
 * - [Default] 默认角色
 * - [Girl] 该语音模拟女孩。
 * - [Boy] 该语音模拟男孩。
 * - [YoungAdultFemale] 该语音模拟年轻成年女性。
 * - [YoungAdultMale] 该语音模拟年轻成年男性。
 * - [OlderAdultFemale] 该语音模拟年长的成年女性。
 * - [OlderAdultMale] 该语音模拟年长的成年男性。
 * - [SeniorFemale] 该语音模拟老年女性。
 * - [SeniorMale] 该语音模拟老年男性。
 *
 */
enum class Role {
    Default,Girl, Boy, YoungAdultFemale, YoungAdultMale, OlderAdultFemale, OlderAdultMale, SeniorFemale, SeniorMale
}