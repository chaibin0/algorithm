package leetcode.q2154

class Solution {
    fun findFinalValue(nums: IntArray, original: Int): Int {
        val numSet = nums.toSet()
        var current = original
        while (numSet.contains(current)) {
            current *= 2
        }

        return current
    }
}