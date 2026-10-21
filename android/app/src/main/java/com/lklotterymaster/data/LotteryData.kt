package com.lklotterymaster.data

import com.lklotterymaster.data.model.*

object LotteryData {
    val DEFINITIONS = listOf(
        LotteryDefinition(
            id = "dlb-ada-kotipathi",
            code = "AK",
            board = LotteryBoard.DLB,
            nameEn = "Ada Kotipathi",
            nameSi = "අද කෝටිපති",
            nameTa = "அத கொடிபதி",
            ticketPrice = 20,
            drawDays = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"),
            numbersCount = 4,
            numberRangeMax = 77,
            hasLetter = true,
            hasZodiac = false,
            hasSuperBall = false,
            samplePrizes = listOf(
                PrizeTier("ak-1", "4 Numbers + English Letter", "අංක 4 + ඉංග්‍රීසි අකුර (සුපිරි ජයමල්ල)", "4 எண்கள் + ஆங்கில எழுத்து", "4N+L", 82865670, true),
                PrizeTier("ak-2", "4 Numbers Correct", "අංක 4 ගැලපීම", "4 எண்கள்", "4N", 2000000),
                PrizeTier("ak-3", "Any 3 Numbers + English Letter", "අංක 3 + ඉංග්‍රීසි අකුර", "3 எண்கள் + ஆங்கில எழுத்து", "3N+L", 200000),
                PrizeTier("ak-4", "Any 3 Numbers Correct", "අංක 3 ගැලපීම", "3 எண்கள்", "3N", 2500)
            )
        ),
        LotteryDefinition(
            id = "dlb-shanida",
            code = "SW",
            board = LotteryBoard.DLB,
            nameEn = "Shanida",
            nameSi = "ශනිදා",
            nameTa = "சனிதா",
            ticketPrice = 20,
            drawDays = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"),
            numbersCount = 4,
            numberRangeMax = 80,
            hasLetter = true,
            hasZodiac = false,
            hasSuperBall = false,
            samplePrizes = listOf(
                PrizeTier("sw-1", "4 Numbers + English Letter (Jackpot)", "අංක 4 + ඉංග්‍රීසි අකුර (සුපිරි ජයමල්ල)", "4 எண்கள் + ஆங்கில எழுத்து", "4N+L", 56131518, true),
                PrizeTier("sw-2", "4 Numbers Correct", "අංක 4 ගැලපීම", "4 எண்கள்", "4N", 2000000),
                PrizeTier("sw-3", "Any 3 Numbers + English Letter", "අංක 3 + ඉංග්‍රීසි අකුර", "3 எண்கள் + ஆங்கில எழுத்து", "3N+L", 200000)
            )
        ),
        LotteryDefinition(
            id = "dlb-lagna-wasana",
            code = "LW",
            board = LotteryBoard.DLB,
            nameEn = "Lagna Wasana",
            nameSi = "ලග්න වාසනාව",
            nameTa = "லக்ன வாசனா",
            ticketPrice = 20,
            drawDays = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"),
            numbersCount = 4,
            numberRangeMax = 60,
            hasLetter = false,
            hasZodiac = true,
            hasSuperBall = false,
            samplePrizes = listOf(
                PrizeTier("lw-1", "4 Numbers + Zodiac Sign", "අංක 4 + ලග්නය (ජයමල්ල)", "4 எண்கள் + ராசி", "4N+Z", 3000000, true),
                PrizeTier("lw-2", "4 Numbers Correct", "අංක 4 ගැලපීම", "4 எண்கள்", "4N", 1000000),
                PrizeTier("lw-3", "Any 3 Numbers + Zodiac Sign", "අංක 3 + ලග්නය", "3 எண்கள் + ராசி", "3N+Z", 20000)
            )
        )
        // More definitions would follow...
    )
}
