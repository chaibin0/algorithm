package leetcode.problems.q3137

import kotlin.math.max

class Solution {
    fun minimumOperationsToMakeKPeriodic(word: String, k: Int): Int {
        val length = word.length / k
        val wordsToCount = HashMap<String, Int>()
        for (i in 1..length) {
            val startIndex = (i - 1) * k
            val subString = word.substring(startIndex, startIndex + k)
            wordsToCount[subString] = wordsToCount.getOrElse(subString) { 0 }
                .plus(1)
        }

        var maxCount = 0
        for (count in wordsToCount.values) {
            maxCount = max(maxCount, count)
        }

        return length - maxCount
    }
}