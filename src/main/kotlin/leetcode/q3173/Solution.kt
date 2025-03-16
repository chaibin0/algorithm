package leetcode.q3173

class Solution {
    fun orArray(nums: IntArray): IntArray {
        val answer = IntArray(nums.size - 1)
        for (i in 0 until (nums.size - 1)) {
            answer[i] = nums[i].or(nums[i + 1])
        }
        return answer
    }
}