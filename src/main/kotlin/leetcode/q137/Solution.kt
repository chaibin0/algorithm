package leetcode.q137

class Solution {
    fun singleNumber(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        return map.entries.find { it.value == 1 }?.key ?: -1
    }
}