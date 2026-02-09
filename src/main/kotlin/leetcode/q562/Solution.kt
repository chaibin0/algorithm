package leetcode.q562


class Solution {

    companion object {
        const val VERTICAL = 0
        const val HORIZONTAL = 1
        const val RIGHT_DIAGONAL = 2
        const val LEFT_DIAGONAL = 3
    }

    fun longestLine(mat: Array<IntArray>): Int {

        val m = mat.size
        val n = mat[0].size

        var maxVertical = 0
        var maxHorizontal = 0
        var maxRightDiagonal = 0
        var maxLeftDiagonal = 0

        val dp = Array(4) {
            Array(m) { IntArray(n) }
        }

        for (i in mat.indices) {
            for (j in mat[i].indices) {
                val current = mat[i][j]
                if (current == 1) {
                    dp[VERTICAL][i][j] = if (i - 1 >= 0) dp[VERTICAL][i - 1][j] + 1 else 1
                    maxVertical = maxOf(maxVertical, dp[VERTICAL][i][j])

                    dp[HORIZONTAL][i][j] = if (j - 1 >= 0) dp[HORIZONTAL][i][j - 1] + 1 else 1
                    maxHorizontal = maxOf(maxHorizontal, dp[HORIZONTAL][i][j])

                    dp[RIGHT_DIAGONAL][i][j] = if (j - 1 >= 0 && i - 1 >= 0) dp[RIGHT_DIAGONAL][i - 1][j - 1] + 1 else 1
                    maxRightDiagonal = maxOf(maxRightDiagonal, dp[RIGHT_DIAGONAL][i][j])

                    dp[LEFT_DIAGONAL][i][j] = if (j + 1 < n && i - 1 >= 0) dp[LEFT_DIAGONAL][i - 1][j + 1] + 1 else 1
                    maxLeftDiagonal = maxOf(maxLeftDiagonal, dp[LEFT_DIAGONAL][i][j])
                } else {
                    dp[VERTICAL][i][j] = 0
                    dp[HORIZONTAL][i][j] = 0
                    dp[RIGHT_DIAGONAL][i][j] = 0
                    dp[LEFT_DIAGONAL][i][j] = 0
                }
            }
        }

        return maxOf(maxVertical, maxHorizontal, maxRightDiagonal, maxLeftDiagonal)
    }
}