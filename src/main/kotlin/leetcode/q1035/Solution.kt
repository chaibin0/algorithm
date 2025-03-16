package leetcode.q1035

import kotlin.math.max

class Solution {

    private lateinit var cache: Array<IntArray>
    private lateinit var visited: Array<BooleanArray>

    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        cache = Array(nums2.size) { IntArray(nums1.size) }
        visited = Array(nums2.size) { BooleanArray(nums1.size) }
        return dfs(0, 0, nums1, nums2)
    }

    private fun dfs(nums1Position: Int, nums2Position: Int, nums1: IntArray, nums2: IntArray): Int {
        if (nums1Position >= nums1.size || nums2Position >= nums2.size) {
            return 0
        }

        if (visited[nums2Position][nums1Position]) {
            return cache[nums2Position][nums1Position]
        }

        var answer = 0
        for (i in nums2Position until nums2.size) {
            for (j in nums1Position until nums1.size) {

                if (visited[i][j]) {
                    continue
                }

                if (nums2[i] == nums1[j]) {
                    answer = max(answer, 1 + dfs(j + 1, i + 1, nums1, nums2))
                }
            }
        }
        visited[nums2Position][nums1Position] = true
        cache[nums2Position][nums1Position] = answer
        return answer
    }
}