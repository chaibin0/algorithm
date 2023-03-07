package leetcode.q1864

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun minSwaps(s: String): Int {

        val firstAnswer = minSwaps(s, true)
        val secondAnswer = minSwaps(s, false)

        return when {
            firstAnswer == -1 && secondAnswer == -1 -> -1
            firstAnswer != -1 && secondAnswer != -1 -> min(firstAnswer, secondAnswer)
            firstAnswer == -1 -> secondAnswer
            secondAnswer == -1 -> firstAnswer
            else -> -1
        }
    }

    private fun minSwaps(s: String, oneStart: Boolean): Int {

        var isOne = oneStart
        var answer = -1
        var needOne = 0
        var needZero = 0

        for (value in s) {

            if (isOne && value == '1') {
                needZero++
            }
            if (!isOne && value == '0') {
                needOne++

            }

            isOne = !isOne
        }
        if (needZero == needOne) {
            answer = needZero
        }
        return answer
    }
}