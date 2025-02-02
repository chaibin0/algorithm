package leetcode.q2161

class Solution {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        val answer = IntArray(nums.size) { 0 }

        var left = 0
        var right = nums.lastIndex
        for ((index, value) in nums.withIndex()) {
            if (value < pivot) {
                answer[left] = value
                left++
            }
        }

        for ((index, value) in nums.reversed().withIndex()) {
            if (value > pivot) {
                answer[right] = value
                right--
            }
        }

        for (i in left..right) {
            answer[i] = pivot
        }

        return answer
    }
}