package leetcode.q238

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {

        val ascent = IntArray(nums.size)
        val descent = IntArray(nums.size)
        val answers = IntArray(nums.size)
        ascent[0] = nums.first()
        descent[nums.lastIndex] = nums.last()

        for (i in 1 until nums.size) {
            ascent[i] = ascent[i - 1] * nums[i]
        }

        for (i in (nums.lastIndex - 1) downTo 0) {
            descent[i] = descent[i + 1] * nums[i]
        }

        for (i in nums.indices) {
            val left = if (i - 1 < 0) 1 else ascent[i - 1]
            val right = if (i + 1 >= nums.size) 1 else descent[i + 1]
            answers[i] = left * right
        }

        return answers
    }
}