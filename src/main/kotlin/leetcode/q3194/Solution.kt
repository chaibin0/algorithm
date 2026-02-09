package leetcode.q3194

class Solution {
    fun countCompleteDayPairs(hours: IntArray): Int {
        var answer = 0
        for (i in hours.indices) {
            for (j in i + 1 until hours.size) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    answer++
                }
            }
        }
        return answer
    }
}