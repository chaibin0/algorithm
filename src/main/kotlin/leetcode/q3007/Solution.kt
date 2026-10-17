package leetcode.q3007
// failed
class Solution {
    fun findMaximumNumber(k: Long, x: Int): Long {
        var accumulatedPrice = 0L
        var num = 1L
        while (true) {
            var price = 0
            var i = 1
            while (1L.rotateLeft(x * i - 1) <= num) {
                val bit = num.rotateRight(x * i - 1).and(1L)
                if (bit == 1L) {
                    price++
                }
                i++
            }

            if (accumulatedPrice + price > k) {
                return (num - 1)
            }

            num++
            accumulatedPrice += price
        }
    }
}