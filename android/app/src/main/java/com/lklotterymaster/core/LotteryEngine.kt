package com.lklotterymaster.core

import com.lklotterymaster.data.LotteryData
import com.lklotterymaster.data.model.*
import com.lklotterymaster.util.ZodiacUtils
import java.text.SimpleDateFormat
import java.util.*

object LotteryEngine {

    fun evaluateTicketMatch(
        ticket: ParsedTicketData,
        allResults: List<LotteryDrawResult>
    ): TicketMatchResult {
        val todayStr = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

        // 1. Invalid Lottery Check
        if (!ticket.isValidLottery) {
            return TicketMatchResult(
                isValidLottery = false,
                isFutureDraw = false,
                hasDrawResult = false,
                hasTicketNumbers = false,
                lotteryName = "Unknown",
                board = ticket.board,
                drawNo = 0,
                drawDate = "",
                ticketNumbers = emptyList(),
                matchedNumbers = emptyList(),
                messageSi = "මෙය වලංගු ශ්‍රී ලාංකික ලොතරැයි QR කේතයක් නොවේ. කරුණාකර නිල DLB හෝ NLB ලොතරැයි ටිකට් පතක් ස්කෑන් කරන්න.",
                messageEn = "This is not a valid Sri Lankan Lottery QR code. Please scan an authentic DLB or NLB ticket.",
                messageTa = "இது செல்லுபடியாகும் இலங்கை லாட்டரி QR குறியீடு அல்ல. சரியான DLB அல்லது NLB டிக்கெட்டை ஸ்கேன் செய்யவும்.",
                rawString = ticket.rawString
            )
        }

        // 2. Find Draw Result
        val drawResult = allResults.find {
            it.board == ticket.board && it.lotteryCode == ticket.lotteryCode && it.drawNo == ticket.drawNo
        }

        // 3. Future Draw Check
        if (drawResult == null && ticket.drawDate > todayStr) {
            return TicketMatchResult(
                isValidLottery = true,
                isFutureDraw = true,
                hasDrawResult = false,
                hasTicketNumbers = ticket.hasTicketNumbers,
                lotteryName = ticket.lotteryName,
                board = ticket.board,
                drawNo = ticket.drawNo,
                drawDate = ticket.drawDate,
                ticketNumbers = ticket.ticketNumbers,
                matchedNumbers = emptyList(),
                messageSi = "මෙම ටිකට් පතට අදාළ දිනුම් ඇදීම තවමත් සිදුකර නොමැත! (${ticket.drawDate}, අංක: #${ticket.drawNo}).",
                messageEn = "The official draw for this ticket has not taken place yet! (Date: ${ticket.drawDate}, Draw #${ticket.drawNo}).",
                messageTa = "இந்த டிக்கெட்டுக்கான குலுக்கல் இன்னும் நடைபெறவில்லை! (${ticket.drawDate}, குலுக்கல் #${ticket.drawNo}).",
                rawString = ticket.rawString
            )
        }

        // 4. Unverified Check
        if (drawResult == null) {
            return TicketMatchResult(
                isValidLottery = true,
                isFutureDraw = false,
                hasDrawResult = false,
                hasTicketNumbers = ticket.hasTicketNumbers,
                lotteryName = ticket.lotteryName,
                board = ticket.board,
                drawNo = ticket.drawNo,
                drawDate = ticket.drawDate,
                ticketNumbers = ticket.ticketNumbers,
                matchedNumbers = emptyList(),
                prizeCategory = "Unverified",
                messageSi = "මෙම ටිකට් පතේ #${ticket.drawNo} නිල ප්‍රතිඵලය තවම ලබාගෙන නොමැත.",
                messageEn = "Official results for #${ticket.drawNo} are not available yet.",
                messageTa = "இந்த டிக்கெட்டுக்கான அதிகாரப்பூர்வ முடிவுகள் இன்னும் கிடைக்கவில்லை.",
                rawString = ticket.rawString
            )
        }

        // 5. Evaluation Logic
        val officialNumbers = drawResult.numbers
        val officialLetter = drawResult.letter
        val officialZodiac = drawResult.zodiac
        val officialSuperBall = drawResult.superBall

        val matchedNumbers = ticket.ticketNumbers.filter { officialNumbers.contains(it) }
        val matchedLetter = ticket.ticketLetter != null && officialLetter != null && 
                          ticket.ticketLetter.trim().equals(officialLetter.trim(), ignoreCase = true)
        val matchedZodiac = ZodiacUtils.isZodiacMatch(ticket.ticketZodiac, officialZodiac)
        val matchedSuperBall = ticket.ticketSuperBall != null && officialSuperBall != null && 
                             ticket.ticketSuperBall == officialSuperBall

        // Placeholder for complex prize calculation based on lottery type
        // This would involve matching against drawResult.prizes or LotteryData.DEFINITIONS
        
        return TicketMatchResult(
            isValidLottery = true,
            isFutureDraw = false,
            hasDrawResult = true,
            hasTicketNumbers = true,
            lotteryName = ticket.lotteryName,
            board = ticket.board,
            drawNo = ticket.drawNo,
            drawDate = ticket.drawDate,
            ticketNumbers = ticket.ticketNumbers,
            matchedNumbers = matchedNumbers,
            matchedLetter = matchedLetter,
            matchedZodiac = matchedZodiac,
            matchedSuperBall = matchedSuperBall,
            isWon = matchedNumbers.isNotEmpty() || matchedLetter || matchedZodiac || matchedSuperBall,
            totalPrize = 0, // In real app, calculate actual prize amount
            rawString = ticket.rawString
        )
    }
}
