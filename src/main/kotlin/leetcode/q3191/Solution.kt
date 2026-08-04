package leetcode.q3191

class Solution {
    fun minOperations(nums: IntArray): Int {

        var count = 0
        for (i in 0 until nums.size - 2) {
            if (nums[i] == 1) {
                continue
            }

            count++
            for (j in i until i + 3) {
                nums[j] = if (nums[j] == 1) 0 else 1
            }
        }

        for (i in nums.size - 3 until nums.size) {
            if (nums[i] == 0) {
                return -1
            }
        }

        return count
    }
}