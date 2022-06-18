/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

package top.limbang.tts.neural

enum class Region(val value: String) {
    Afrikaans_SouthAfrica("af-ZA"),
    Amharic_Ethiopia("am-ET"),
    Arabic_Algeria("ar-DZ"),
    Arabic_Bahrain("ar-BH"),
    Arabic_Egypt("ar-EG"),
    Arabic_Iraq("ar-IQ"),
    Arabic_Jordan("ar-JO"),
    Arabic_Kuwait("ar-KW"),
    Arabic_Libya("ar-LY"),
    Arabic_Morocco("ar-MA"),
    Arabic_Qatar("ar-QA"),
    Arabic_SaudiArabia("ar-SA"),
    Arabic_Syria("ar-SY"),
    Arabic_Tunisia("ar-TN"),
    Arabic_UnitedArabEmirates("ar-AE"),
    Arabic_Yemen("ar-YE"),
    Bangla_Bangladesh("bn-BD"),
    Bengali_India("bn-IN"),
    Bulgarian_Bulgaria("bg-BG"),
    Burmese_Myanmar("my-MM"),
    Catalan_Spain("ca-ES"),
    Chinese_CantoneseTraditional("zh-HK"),
    Chinese_MandarinSimplified("zh-cn"),
    Chinese_TaiwaneseMandarin("zh-TW"),
    Croatian_Croatia("hr-HR"),
    Czech_Czech("cs-CZ"),
    Danish_Denmark("da-DK"),
    Dutch_Belgium("nl-BE"),
    Dutch_Netherlands("nl-NL"),
    English_Australia("en-AU"),
    English_Canada("en-CA"),
    English_Hongkong("en-HK"),
    English_India("en-IN"),
    English_Ireland("en-IE"),
    English_Kenya("en-KE"),
    English_NewZealand("en-NZ"),
    English_Nigeria("en-NG"),
    English_Philippines("en-PH"),
    English_Singapore("en-SG"),
    English_SouthAfrica("en-ZA"),
    English_Tanzania("en-TZ"),
    English_UnitedKingdom("en-GB"),
    English_UnitedStates("en-US"),
    Estonian_Estonia("et-EE"),
    Filipino_Philippines("fil-PH"),
    Finnish_Finland("fi-FI"),
    French_Belgium("fr-BE"),
    French_Canada("fr-CA"),
    French_France("fr-FR"),
    French_Switzerland("fr-CH"),
    Galician_Spain("gl-ES"),
    German_Austria("de-AT"),
    German_Germany("de-DE"),
    German_Switzerland("de-CH"),
    Greek_Greece("el-GR"),
    Gujarati_India("gu-IN"),
    Hebrew_Israel("he-IL"),
    Hindi_India("hi-IN"),
    Hungarian_Hungary("hu-HU"),
    Icelandic_Iceland("is-IS"),
    Indonesian_Indonesia("id-ID"),
    Irish_Ireland("ga-IE"),
    Italian_Italy("it-IT"),
    Japanese_Japan("ja-JP"),
    Javanese_Indonesia("jv-ID"),
    Kannada_India("kn-IN"),
    Kazakh_Kazakhstan("kk-KZ"),
    Khmer_Cambodia("km-KH"),
    Korean_Korea("ko-KR"),
    Lao_Laos("lo-LA"),
    Latvian_Latvia("lv-LV"),
    Lithuanian_Lithuania("lt-LT"),
    Macedonian_RepublicofNorthMacedonia("mk-MK"),
    Malay_Malaysia("ms-MY"),
    Malayalam_India("ml-IN"),
    Maltese_Malta("mt-MT"),
    Marathi_India("mr-IN"),
    Norwegian_BokmålNorway("nb-NO"),
    Pashto_Afghanistan("ps-AF"),
    Persian_Iran("fa-IR"),
    Polish_Poland("pl-PL"),
    Portuguese_Brazil("pt-BR"),
    Portuguese_Portugal("pt-PT"),
    Romanian_Romania("ro-RO"),
    Russian_Russia("ru-RU"),
    Serbian_SerbiaCyrillic("sr-RS"),
    Sinhala_SriLanka("si-LK"),
    Slovak_Slovakia("sk-SK"),
    Slovenian_Slovenia("sl-SI"),
    Somali_Somalia("so-SO"),
    Spanish_Argentina("es-AR"),
    Spanish_Bolivia("es-BO"),
    Spanish_Chile("es-CL"),
    Spanish_Colombia("es-CO"),
    Spanish_CostaRica("es-CR"),
    Spanish_Cuba("es-CU"),
    Spanish_DominicanRepublic("es-DO"),
    Spanish_Ecuador("es-EC"),
    Spanish_ElSalvador("es-SV"),
    Spanish_EquatorialGuinea("es-GQ"),
    Spanish_Guatemala("es-GT"),
    Spanish_Honduras("es-HN"),
    Spanish_Mexico("es-MX"),
    Spanish_Nicaragua("es-NI"),
    Spanish_Panama("es-PA"),
    Spanish_Paraguay("es-PY"),
    Spanish_Peru("es-PE"),
    Spanish_PuertoRico("es-PR"),
    Spanish_Spain("es-ES"),
    Spanish_Uruguay("es-UY"),
    Spanish_US("es-US"),
    Spanish_Venezuela("es-VE"),
    Sundanese_Indonesia("su-ID"),
    Swahili_Kenya("sw-KE"),
    Swahili_Tanzania("sw-TZ"),
    Swedish_Sweden("sv-SE"),
    Tamil_India("ta-IN"),
    Tamil_Singapore("ta-SG"),
    Tamil_SriLanka("ta-LK"),
    Telugu_India("te-IN"),
    Thai_Thailand("th-TH"),
    Turkish_Turkey("tr-TR"),
    Ukrainian_Ukraine("uk-UA"),
    Urdu_India("ur-IN"),
    Urdu_Pakistan("ur-PK"),
    Uzbek_Uzbekistan("uz-UZ"),
    Vietnamese_Vietnam("vi-VN"),
    Welsh_UnitedKingdom("cy-GB"),
    Zulu_SouthAfrica("zu-ZA"),
}