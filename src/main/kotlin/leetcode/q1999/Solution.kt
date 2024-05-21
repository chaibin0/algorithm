package leetcode.q1999

import kotlin.math.min

class Solution {

    private var visited: MutableSet<Long> = mutableSetOf()
    private var answer: Int = Int.MAX_VALUE

    fun findInteger(k: Int, digit1: Int, digit2: Int): Int {
        val deque = ArrayDeque<Long>()
        val (smallDigit, largeDigit) = if (digit1 < digit2) {
            digit1.toLong() to digit2.toLong()
        } else {
            digit2.toLong() to digit1.toLong()
        }

        if (smallDigit > k && smallDigit % k == 0L) {
            return smallDigit.toInt()
        }

        if (largeDigit > k && largeDigit % k == 0L) {
            return largeDigit.toInt()
        }

        visited.add(smallDigit)
        visited.add(largeDigit)

        deque.addLast(smallDigit)
        deque.addLast(largeDigit)

        while (deque.isNotEmpty()) {
            val num = deque.removeFirst()
            val nextSmallNum = num * 10 + smallDigit

            if (isPossible(nextSmallNum, k)) {

                if (k < nextSmallNum && nextSmallNum % k == 0L) {
                    answer = min(answer, nextSmallNum.toInt())
                }
                visited.add(nextSmallNum)
                deque.addLast(nextSmallNum)
            }

            val nextLargeNum = num * 10 + largeDigit
            if (isPossible(nextLargeNum, k)) {

                if (k < nextLargeNum && nextLargeNum % k == 0L) {
                    answer = min(answer, nextLargeNum.toInt())
                }
                visited.add(nextLargeNum)
                deque.addLast(nextLargeNum)
            }
        }

        return if (answer == Int.MAX_VALUE) -1 else answer
    }

    private fun isPossible(num: Long, k: Int): Boolean {
        if (num <= 0 || num > Int.MAX_VALUE) {
            return false
        }

        if (visited.contains(num)) {
            return false
        }

        if (answer <= num) {
            return false
        }

        return true
    }
}