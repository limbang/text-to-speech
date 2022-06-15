/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.ssml

/**
 * ## 说话风格
 * - [General] 一般风格。
 * - [AdvertisementUpbeat] 用兴奋和精力充沛的语气推广产品或服务。
 * - [Affectionate] 以较高的音调和音量表达温暖而亲切的语气。 说话者处于吸引听众注意力的状态。 说话者的个性往往是讨喜的。
 * - [Angry] 表达生气和厌恶的语气。
 * - [Assistant] 以热情而轻松的语气对数字助理讲话。
 * - [Calm] 以沉着冷静的态度说话。 语气、音调和韵律与其他语音类型相比要统一得多。
 * - [Chat] 表达轻松随意的语气。
 * - [Cheerful] 表达积极愉快的语气。
 * - [CustomerService] 以友好热情的语气为客户提供支持。
 * - [Depressed] 调低音调和音量来表达忧郁、沮丧的语气。
 * - [Disgruntled] 表达轻蔑和抱怨的语气。 这种情绪的语音表现出不悦和蔑视。
 * - [Embarrassed] 在说话者感到不舒适时表达不确定、犹豫的语气。
 * - [Empathetic] 表达关心和理解。
 * - [Envious] 当你渴望别人拥有的东西时，表达一种钦佩的语气。
 * - [Excited] 表达乐观和充满希望的语气。 似乎发生了一些美好的事情，说话人对此非常满意。
 * - [Fearful] 以较高的音调、较高的音量和较快的语速来表达恐惧、紧张的语气。 说话人处于紧张和不安的状态。
 * - [Friendly] 表达一种愉快、怡人且温暖的语气。 听起来很真诚且满怀关切。
 * - [Gentle] 以较低的音调和音量表达温和、礼貌和愉快的语气。
 * - [Hopeful] 表达一种温暖且渴望的语气。 听起来像是会有好事发生在说话人身上。
 * - [Lyrical] 以优美又带感伤的方式表达情感。
 * - [NarrationProfessional] 以专业、客观的语气朗读内容。
 * - [NarrationRelaxed] 为内容阅读表达一种舒缓而悦耳的语气。
 * - [Newscast] 以正式专业的语气叙述新闻。
 * - [NewscastCasual] 以通用、随意的语气发布一般新闻。
 * - [NewscastFormal] 以正式、自信和权威的语气发布新闻。
 * - [Sad] 表达悲伤语气。
 * - [Serious] 表达严肃和命令的语气。 说话者的声音通常比较僵硬，节奏也不那么轻松。
 * - [Shouting] 就像从遥远的地方说话或在外面说话，但能让自己清楚地听到
 * - [SportsCommentary] 用轻松有趣的语气播报体育赛事。
 * - [SportsCommentaryExcited] 用快速且充满活力的语气播报体育赛事精彩瞬间。
 * - [Whispering] 说话非常柔和，发出的声音小且温柔
 * - [Terrified] 表达一种非常害怕的语气，语速快且声音颤抖。 听起来说话人处于不稳定的疯狂状态。
 * - [Unfriendly] 表达一种冷淡无情的语气。
 * - [PoetryReading] 诗歌朗读
 *
 * @param value
 */
enum class Style (val value: String){
    /** 一般风格 */
    General("General"),
    /** 用兴奋和精力充沛的语气推广产品或服务。 */
    AdvertisementUpbeat("advertisement-upbeat"),
    /** 以较高的音调和音量表达温暖而亲切的语气。 说话者处于吸引听众注意力的状态。 说话者的个性往往是讨喜的。 */
    Affectionate("affectionate"),
    /** 表达生气和厌恶的语气。 */
    Angry("angry"),
    /** 以热情而轻松的语气对数字助理讲话。 */
    Assistant("assistant"),
    /** 以沉着冷静的态度说话。 语气、音调和韵律与其他语音类型相比要统一得多。 */
    Calm("calm"),
    /** 表达轻松随意的语气。 */
    Chat("chat"),
    /** 表达积极愉快的语气。 */
    Cheerful("cheerful"),
    /** 以友好热情的语气为客户提供支持。 */
    CustomerService("customerservice"),
    /** 调低音调和音量来表达忧郁、沮丧的语气。 */
    Depressed("depressed"),
    /** 表达轻蔑和抱怨的语气。 这种情绪的语音表现出不悦和蔑视。 */
    Disgruntled("disgruntled"),
    /** 在说话者感到不舒适时表达不确定、犹豫的语气。 */
    Embarrassed("embarrassed"),
    /** 表达关心和理解。 */
    Empathetic("empathetic"),
    /** 当你渴望别人拥有的东西时，表达一种钦佩的语气。 */
    Envious("envious"),
    /** 表达乐观和充满希望的语气。 似乎发生了一些美好的事情，说话人对此非常满意。 */
    Excited("excited"),
    /** 以较高的音调、较高的音量和较快的语速来表达恐惧、紧张的语气。 说话人处于紧张和不安的状态。 */
    Fearful("fearful"),
    /** 表达一种愉快、怡人且温暖的语气。 听起来很真诚且满怀关切。 */
    Friendly("friendly"),
    /** 以较低的音调和音量表达温和、礼貌和愉快的语气。 */
    Gentle("gentle"),
    /** 表达一种温暖且渴望的语气。 听起来像是会有好事发生在说话人身上。 */
    Hopeful("hopeful"),
    /** 以优美又带感伤的方式表达情感。 */
    Lyrical("lyrical"),
    /** 以专业、客观的语气朗读内容。 */
    NarrationProfessional("narration-professional"),
    /** 为内容阅读表达一种舒缓而悦耳的语气。 */
    NarrationRelaxed("narration-relaxed"),
    /** 以正式专业的语气叙述新闻。 */
    Newscast("newscast"),
    /** 以通用、随意的语气发布一般新闻。 */
    NewscastCasual("newscast-casual"),
    /** 以正式、自信和权威的语气发布新闻。 */
    NewscastFormal("newscast-formal"),
    /** 表达悲伤语气。 */
    Sad("sad"),
    /** 表达严肃和命令的语气。 说话者的声音通常比较僵硬，节奏也不那么轻松。 */
    Serious("serious"),
    /** 就像从遥远的地方说话或在外面说话，但能让自己清楚地听到 */
    Shouting("shouting"),
    /** 用轻松有趣的语气播报体育赛事。 */
    SportsCommentary("sports-commentary"),
    /** 用快速且充满活力的语气播报体育赛事精彩瞬间。 */
    SportsCommentaryExcited("sports-commentary-excited"),
    /** 说话非常柔和，发出的声音小且温柔 */
    Whispering("whispering"),
    /** 表达一种非常害怕的语气，语速快且声音颤抖。 听起来说话人处于不稳定的疯狂状态。 */
    Terrified("terrified"),
    /** 表达一种冷淡无情的语气。 */
    Unfriendly("unfriendly"),
    /** 诗歌朗诵 */
    PoetryReading("poetry-reading")
}