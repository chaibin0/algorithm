package leetcode.q2428

class Solution {
    fun maxSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val prefixSum = Array(m + 1) { IntArray(n + 1) }
        for (i in 1..m) {
            for (j in 1..n) {
                prefixSum[i][j] =
                    grid[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1]
            }
        }

        var maxSum = 0

        for (i in 3..m) {
            for (j in 3..n) {
                maxSum = maxOf(
                    maxSum,
                    (prefixSum[i][j] - prefixSum[i - 3][j] - prefixSum[i][j - 3] + prefixSum[i - 3][j - 3])
                            - (grid[i - 2][j - 3] + grid[i - 2][j - 1])
                )

            }
        }
        return maxSum
    }
}