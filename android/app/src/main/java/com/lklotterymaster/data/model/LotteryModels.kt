package com.lklotterymaster.data.model

import java.util.Date

enum class LotteryBoard {
    DLB, NLB
}

enum class LotteryType(val code: String) {
    N4_L("4N+L"),
    N6D_L("6D+L"),
    N4N_Z("4N+Z"),
    N3N_Z("3N+Z"),
    N4N_L_SB("4N+L+SB"),
    N4D_REV_L("4D+REV+L"),
    N2N_L_SB("2N+L+SB"),
    N4D_L("4D+L"),
    N3N("3N"),
    N6D("6D"),
    UNKNOWN("UNKNOWN")
}

data class PrizeTier(
    val id: String,
    val categoryNameEn: String,
    val categoryNameSi: String,
    val categoryNameTa: String,
    val matchRule: String,
    val prizeAmount: Long,
    val isJackpot: Boolean = false
)

data class LotteryDefinition(
    val id: String,
    val code: String,
    val board: LotteryBoard,
    val nameEn: String,
    val nameSi: String,
    val nameTa: String,
    val ticketPrice: Int,
    val drawDays: List<String>,
    val numbersCount: Int,
    val numberRangeMax: Int,
    val hasLetter: Boolean,
    val hasZodiac: Boolean,
    val hasSuperBall: Boolean,
    val samplePrizes: List<PrizeTier>
)

data class LotteryDrawResult(
    val lotteryId: String,
    val lotteryCode: String,
    val board: LotteryBoard,
    val lotteryName: String,
    val drawNo: Int,
    val drawDate: String, // ISO YYYY-MM-DD
    val numbers: List<Int>,
    val letter: String? = null,
    val zodiac: String? = null,
    val superBall: Int? = null,
    val jackpotAmount: Long? = null,
    val prizes: List<PrizeTier>? = null
)

data class ParsedTicketData(
    val isValidLottery: Boolean,
    val isFutureDraw: Boolean,
    val hasTicketNumbers: Boolean,
    val board: LotteryBoard,
    val lotteryCode: String,
    val lotteryName: String,
    val drawNo: Int,
    val drawDate: String,
    val ticketNumbers: List<Int>,
    val ticketLetter: String? = null,
    val ticketZodiac: String? = null,
    val ticketSuperBall: Int? = null,
    val lotteryType: LotteryType = LotteryType.N4_L,
    val rawString: String
)

data class TicketMatchResult(
    val isValidLottery: Boolean,
    val isFutureDraw: Boolean,
    val hasDrawResult: Boolean,
    val hasTicketNumbers: Boolean,
    val lotteryName: String,
    val board: LotteryBoard,
    val drawNo: Int,
    val drawDate: String,
    val ticketNumbers: List<Int>,
    val matchedNumbers: List<Int>,
    val matchedLetter: Boolean = false,
    val matchedZodiac: Boolean = false,
    val matchedSuperBall: Boolean = false,
    val isWon: Boolean = false,
    val totalPrize: Long = 0,
    val prizeCategory: String? = null,
    val messageEn: String? = null,
    val messageSi: String? = null,
    val messageTa: String? = null,
    val rawString: String
)
