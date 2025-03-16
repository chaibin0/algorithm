package leetcode.q494

class Solution {

    val map: MutableMap<Pair<Int, Int>, Int> = HashMap()

    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        return dfs(nums, target, 0)
    }

    fun dfs(nums: IntArray, target: Int, position: Int): Int {

        if (position == nums.size) {
            return if (target == 0) 1 else 0
        }

        if (map.containsKey(Pair(position, target))) {
            return map[Pair(position, target)]!!
        }

        val result = dfs(nums, target + nums[position], position + 1) +
                dfs(nums, target - nums[position], position + 1)


        map[Pair(position, target)] = result
        return result
    }
}