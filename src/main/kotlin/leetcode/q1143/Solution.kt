package leetcode.q1143

import kotlin.math.max

class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {

        var answer = 0


        var dp1 = IntArray(text1.length)

        for ((index2, value2) in text2.withIndex()) {

            val dp2 = IntArray(text1.length)

            for ((index1, value1) in text1.withIndex()) {

                if (value1 == value2 && index1 - 1 < 0) {
                    dp2[index1] = 1
                    answer = max(dp2[index1], answer)
                    continue
                }

                if (value1 == value2) {
                    dp2[index1] = max(dp1[index1], dp1[index1 - 1] + 1)
                    answer = max(dp2[index1], answer)
                    continue
                }

                dp2[index1] = if (index1 - 1 >= 0) {
                    max(dp2[index1 - 1], dp1[index1])
                } else {
                    dp1[index1]
                }
            }

            dp1 = dp2
        }

        return answer
    }
}