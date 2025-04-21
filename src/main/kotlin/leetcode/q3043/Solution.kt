package leetcode.q3043

import kotlin.math.max

class Solution {
    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {

        var answer = 0
        val prefixSet = hashSetOf<Int>()

        for (arr in arr1) {
            val value = arr.toString()
            val sb = StringBuilder()
            for (i in value) {
                sb.append(i)
                prefixSet.add(sb.toString().toInt())
            }
        }

        for (arr in arr2) {
            val value = arr.toString()
            val sb = StringBuilder()
            for (i in value) {
                sb.append(i)

                if (sb.length <= answer) {
                    continue
                }

                if (prefixSet.contains(sb.toString().toInt())) {
                    answer = max(answer, sb.length)
                }
            }
        }

        return answer
    }
}