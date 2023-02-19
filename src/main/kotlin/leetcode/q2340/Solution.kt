package leetcode.q2340

class Solution {
    fun minimumSwaps(nums: IntArray): Int {

        var minimum = Int.MAX_VALUE
        var minimumIndex = 0
        var maximum = 0
        var maximumIndex = 0

        if (nums.size == 1) {
            return 0
        }

        for ((i, num) in nums.withIndex()) {
            if (minimum > num) {
                minimumIndex = i
                minimum = num
            }

            if (maximum <= num) {
                maximumIndex = i
                maximum = num
            }
        }

        return minimumIndex + (nums.lastIndex - maximumIndex) - if (minimumIndex > maximumIndex) 1 else 0
    }
}