package leetcode.q962

class Solution {
    fun maxWidthRamp(nums: IntArray): Int {

        var answer = 0
        for (i in nums.indices) {
            var current = 0
            for (j in i + answer + 1 until nums.size) {
                if (nums[i] <= nums[j]) {
                    current = maxOf(current, j - i)
                }
            }

            answer = maxOf(answer, current)
        }

        return answer
    }
}