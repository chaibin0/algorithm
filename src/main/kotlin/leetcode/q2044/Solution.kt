package leetcode.q2044

class Solution {
    var answer = 0

    fun countMaxOrSubsets(nums: IntArray): Int {
        val max = nums.asSequence().reduce { acc, i -> acc or i }
        nums.sortDescending()
        dfs(nums, 0, 0, max)
        return 1
    }

    private fun dfs(nums: IntArray, position: Int, subset: Int, max: Int) {

        if (position == nums.size) return
        val newSubset = subset or nums[position]
        if (newSubset == max) {
            answer++
        }

        dfs(nums, position + 1, newSubset, max)
        dfs(nums, position + 1, subset, max)
    }
}