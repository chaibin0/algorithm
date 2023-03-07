package leetcode.q2386

class Solution {

    private val sumList: MutableList<Long> = mutableListOf()

    fun kSum(nums: IntArray, k: Int): Long {
        calculate(0, nums, 0, true)
        sumList.sortDescending()
        return sumList[k - 1]
    }

    private fun calculate(i: Int, nums: IntArray, currentSum: Long, included: Boolean) {

        if (included) {
            sumList.add(currentSum)
        }

        if (i == nums.size) {
            return
        }

        calculate(i + 1, nums, currentSum + nums[i], true)
        calculate(i + 1, nums, currentSum, false)
    }
}