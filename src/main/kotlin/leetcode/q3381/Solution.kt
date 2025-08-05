package leetcode.q3381

class Solution {
    fun maxSubarraySum(nums: IntArray, k: Int): Long {
        nums.sortDescending()
        val groups = (nums.size / k) * k
        var answer = 0L
        for (i in 0 until groups) {

            answer += nums[i]
        }

        return answer
    }
}