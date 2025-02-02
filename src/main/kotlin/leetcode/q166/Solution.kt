package leetcode.q166

import kotlin.math.abs

class Solution {
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        val absNumerator = abs(numerator.toLong())
        val absDenominator = abs(denominator.toLong())

        val cache = mutableMapOf<Long, Int>()
        var integerPart = 0L
        val floatPart = StringBuilder()

        var isRepeat = false
        var repeatIndex = 0

        val minusFlag = if(numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) "-" else ""
        if (absNumerator >= absDenominator) {
            integerPart = absNumerator / absDenominator
        }

        var current = (absNumerator % absDenominator) * 10
        var floatPartIndex = 0

        while (current != 0L) {
            if (floatPart.isNotEmpty() && cache.containsKey(current)) {
                isRepeat = true
                repeatIndex = cache[current]!!
                break
            }

            cache[current] = floatPartIndex
            floatPartIndex++

            val quotient = current / absDenominator
            current %= absDenominator
            floatPart.append(abs(quotient))
            current *= 10
        }

        if (isRepeat) {
            return "${minusFlag}${integerPart}.${floatPart.substring(0, repeatIndex)}(${floatPart.substring(repeatIndex)})"
        }

        if (floatPart.isNotEmpty()) {
            return "${minusFlag}${integerPart}.${floatPart}"
        }

        return "${minusFlag}${integerPart}"
    }
}