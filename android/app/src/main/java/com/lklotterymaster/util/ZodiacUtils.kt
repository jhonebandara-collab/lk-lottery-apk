package com.lklotterymaster.util

data class ZodiacInfo(
    val si: String,
    val en: String,
    val ta: String,
    val index: Int
)

object ZodiacUtils {
    val ZODIAC_MAPPING = mapOf(
        "aries" to ZodiacInfo("මේෂ", "Aries", "மேஷம்", 1),
        "mesha" to ZodiacInfo("මේෂ", "Aries", "மேஷம்", 1),
        "මේෂ" to ZodiacInfo("මේෂ", "Aries", "மேஷம்", 1),
        "மேஷம்" to ZodiacInfo("මේෂ", "Aries", "மேஷம்", 1),
        
        "taurus" to ZodiacInfo("වෘෂභ", "Taurus", "ரிஷபம்", 2),
        "vrushabha" to ZodiacInfo("වෘෂභ", "Taurus", "ரிஷபம்", 2),
        "වෘෂභ" to ZodiacInfo("වෘෂභ", "Taurus", "ரிෂபம்", 2),
        "ரிஷபம்" to ZodiacInfo("වෘෂභ", "Taurus", "ரிஷபம்", 2),
        
        "gemini" to ZodiacInfo("මිථුන", "Gemini", "மிதுனம்", 3),
        "mithuna" to ZodiacInfo("මිථුන", "Gemini", "மிதுனம்", 3),
        "මිථුන" to ZodiacInfo("මිථුන", "Gemini", "மிதுனம்", 3),
        "மிதுனம்" to ZodiacInfo("මිථුන", "Gemini", "மிதுனம்", 3),
        
        "cancer" to ZodiacInfo("කටක", "Cancer", "கடகம்", 4),
        "kataka" to ZodiacInfo("කටක", "Cancer", "கடகம்", 4),
        "කටක" to ZodiacInfo("කටක", "Cancer", "கடகம்", 4),
        "கடகம்" to ZodiacInfo("කටක", "Cancer", "கடகம்", 4),
        
        "leo" to ZodiacInfo("සිංහ", "Leo", "சிம்மம்", 5),
        "sinha" to ZodiacInfo("සිංහ", "Leo", "சிம்மம்", 5),
        "සිංහ" to ZodiacInfo("සිංහ", "Leo", "சிம்மம்", 5),
        "சிம்மம்" to ZodiacInfo("සිංහ", "Leo", "சிம்மம்", 5),
        
        "virgo" to ZodiacInfo("කන්‍යා", "Virgo", "கன்னி", 6),
        "kanya" to ZodiacInfo("කන්‍යා", "Virgo", "கன்னி", 6),
        "කන්‍යා" to ZodiacInfo("කන්‍යා", "Virgo", "கன்னி", 6),
        "கன்னி" to ZodiacInfo("කන්‍යා", "Virgo", "கன்னி", 6),
        
        "libra" to ZodiacInfo("තුලා", "Libra", "துலாம்", 7),
        "thula" to ZodiacInfo("තුලා", "Libra", "துலாம்", 7),
        "තුලා" to ZodiacInfo("තුලා", "Libra", "துலாம்", 7),
        "துலாம்" to ZodiacInfo("තුලා", "Libra", "துலாம்", 7),
        
        "scorpio" to ZodiacInfo("වෘශ්චික", "Scorpio", "விருச்சிகம்", 8),
        "vrushchika" to ZodiacInfo("වෘශ්චික", "Scorpio", "விருச்சிகம்", 8),
        "වෘශ්චික" to ZodiacInfo("වෘශ්චික", "Scorpio", "விருச்சிகம்", 8),
        "விருச்சிகம்" to ZodiacInfo("වෘශ්චික", "Scorpio", "விருச்சிகம்", 8),
        
        "sagittarius" to ZodiacInfo("ධනු", "Sagittarius", "தனுசு", 9),
        "dhanu" to ZodiacInfo("ධනු", "Sagittarius", "தனுசு", 9),
        "ධනු" to ZodiacInfo("ධනු", "Sagittarius", "தනුசு", 9),
        "தனுசு" to ZodiacInfo("ධනු", "Sagittarius", "தනුசு", 9),
        
        "capricorn" to ZodiacInfo("මකර", "Capricorn", "மகரம்", 10),
        "makara" to ZodiacInfo("මකර", "Capricorn", "மகரம்", 10),
        "මකර" to ZodiacInfo("මකර", "Capricorn", "மகரம்", 10),
        "மகரம்" to ZodiacInfo("මකර", "Capricorn", "மகரம்", 10),
        
        "aquarius" to ZodiacInfo("කුම්භ", "Aquarius", "கும்பம்", 11),
        "kumbha" to ZodiacInfo("කුම්භ", "Aquarius", "கும்பம்", 11),
        "කුම්භ" to ZodiacInfo("කුම්භ", "Aquarius", "கும்பம்", 11),
        "கும்பம்" to ZodiacInfo("කුම්භ", "Aquarius", "கும்பம்", 11),
        
        "pisces" to ZodiacInfo("මීන", "Pisces", "மீனம்", 12),
        "meena" to ZodiacInfo("මීන", "Pisces", "மீனம்", 12),
        "මීන" to ZodiacInfo("මීන", "Pisces", "மீனம்", 12),
        "மீனம்" to ZodiacInfo("මීන", "Pisces", "மீனம்", 12)
    )

    fun mapLetterToZodiac(letter: String?): ZodiacInfo? {
        if (letter.isNullOrBlank()) return null
        val clean = letter.trim().uppercase()
        if (clean.length == 1 && clean[0] in 'A'..'L') {
            val index = clean[0].toInt() - 'A'.toInt() + 1
            return ZODIAC_MAPPING.values.find { it.index == index }
        }
        return normalizeZodiac(clean)
    }

    fun normalizeZodiac(raw: String?): ZodiacInfo? {
        if (raw.isNullOrBlank()) return null
        val clean = raw.trim().lowercase()
        return ZODIAC_MAPPING[clean]
    }

    fun isZodiacMatch(z1: String?, z2: String?): Boolean {
        if (z1 == null || z2 == null) return false
        val n1 = normalizeZodiac(z1) ?: mapLetterToZodiac(z1)
        val n2 = normalizeZodiac(z2) ?: mapLetterToZodiac(z2)
        return n1 != null && n2 != null && n1.index == n2.index
    }
}
