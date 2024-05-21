package leetcode.q2735

class Solution {
    fun minCost(nums: IntArray, x: Int): Long {
        var answer = 0
        var collectCount = 0
        val visited = BooleanArray(nums.size)
        val types = IntArray(nums.size) { it }

        while (collectCount != nums.size) {

            var isBought = false

            for (type in types) {
                if (visited[type]) {
                    continue
                }

                if (nums[type] <= x) {
                    isBought = true
                    visited[type] = true
                }
            }

            if (!isBought) {
                break
            }

            for ((index, type) in types.withIndex()) {
                types[index] = (type + 1).mod(nums.size)
            }
        }

       return 0L
    }
}