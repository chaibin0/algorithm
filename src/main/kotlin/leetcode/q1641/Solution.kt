package leetcode.q1641

class Solution {
    fun countVowelStrings(n: Int): Int {
        val dp = Array(n) {
            IntArray(6) { 0 }
        }

        val sumArray = IntArray(n) { 0 }

        if (n == 1) {
            return 5
        }

        for (j in 1..5) {
            dp[0][j] = 1
        }

        sumArray[0] = 5

        for (i in 1 until n) {
            var lastSum = sumArray[i - 1]
            var newSum = 0
            for (j in 1..5) {
                lastSum -= dp[i - 1][j - 1]
                dp[i][j] = lastSum
                newSum += lastSum
            }

            sumArray[i] = newSum
        }

        return sumArray[n - 1]
    }
}