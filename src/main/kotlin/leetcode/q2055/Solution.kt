package leetcode.q2055

class Solution {
    fun platesBetweenCandles(s: String, queries: Array<IntArray>): IntArray {
        val left = IntArray(s.length) { -1 }
        val right = IntArray(s.length) { s.length }
        val sum = IntArray(s.length) { 0 }
        var currentLeft = -1
        for ((index, value) in s.withIndex()) {
            if (value == '*') {
                sum[index] = if (index - 1 >= 0) sum[index - 1] + 1 else 1
                left[index] = currentLeft
                continue
            }
            sum[index] = if (index - 1 >= 0) sum[index - 1] else 0
            currentLeft = index
            left[index] = currentLeft
        }

        var currentRight = s.length
        for ((index, value) in s.reversed().withIndex()) {
            if (value == '*') {
                right[s.lastIndex - index] = currentRight
                continue
            }
            currentRight = s.lastIndex - index
            right[s.lastIndex - index] = currentRight
        }

        val answer = IntArray(queries.size) { 0 }
        for ((index, query) in queries.withIndex()) {
            val (leftPosition, rightPosition) = query

            answer[index] =
                (sum[rightPosition] - sum[leftPosition] - (rightPosition - left[rightPosition]) - (right[leftPosition] - leftPosition) + if (s[leftPosition] == '*') 1 else 0)
            if (answer[index] < 0) {
                answer[index] = 0
            }
        }

        return answer
    }
}