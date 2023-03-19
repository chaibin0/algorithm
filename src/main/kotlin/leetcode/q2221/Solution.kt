package leetcode.q2221

class Solution {
    fun triangularSum(nums: IntArray): Int {
        var times = nums.size - 1

        var newNums = nums

        for (i in 0 until times) {

            val tempNums = IntArray(times) { 0 }

            for (j in 0 until times) {
                tempNums[j] = (newNums[j] + newNums[j + 1]) % 10
            }
            newNums = tempNums
            times--
        }
        return newNums[0]
    }
}