package leetcode.q539

import kotlin.math.abs
import kotlin.math.min

class Solution {
    fun findMinDifference(timePoints: List<String>): Int {

        val timeMinutes = timePoints.map { timePoint ->
            val (hour, minute) = timePoint.split(":")
                .map { it.toInt() }
            hour * 60 + minute
        }.toIntArray()

        timeMinutes.sort()

        var result = abs((timeMinutes[0] + 1440) - timeMinutes.last())
        for (i in 1 until timeMinutes.size) {
            result = min(result, abs(timeMinutes[i] - timeMinutes[i - 1]))
        }

        return result
    }
}