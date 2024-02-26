package leetcode.q1822

class Solution {
    fun arraySign(nums: IntArray): Int {
        var minusCount = 0

        for (num in nums) {
            when {
                (num == 0) -> {
                    return 0
                }

                (num < 0) -> {
                    minusCount++
                }
            }
        }

        return if (minusCount % 2 == 1) -1 else 1
    }
}