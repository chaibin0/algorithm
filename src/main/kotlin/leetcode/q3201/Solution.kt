package leetcode.q3201

class Solution {
    fun maximumLength(nums: IntArray): Int {
        if (nums.size <= 2) {
            return nums.size
        }

        val onlyOne = nums.count { it % 2 == 1 }
        val onlyZero = nums.count { it % 2 == 0 }
        var cross = 1
        var current = nums[0] % 2
        for (i in 1 until nums.size) {
            val next = nums[i] % 2
            if (current != next) {
                cross++
            }
            current = next
        }

        return maxOf(onlyOne, onlyZero, cross)
    }
}