package leetcode.q496

class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val answer = IntArray(nums1.size)
        val map = HashMap<Int, Int>()
        for ((index, value) in nums2.withIndex()) {
            map[value] = index
        }

        for ((i, num) in nums1.withIndex()) {
            if (map[num] == nums2.lastIndex) {
                answer[i] = -1
                continue
            }

            val nextElement = map[num]!! + 1
            var isGreaterThanElement = false

            for (j in nextElement until nums2.size) {
                if (nums2[j] > num) {
                    answer[i] = nums2[j]
                    isGreaterThanElement = true
                    break
                }
            }

            if (!isGreaterThanElement) {
                answer[i] = -1
            }
        }
        return answer
    }
}