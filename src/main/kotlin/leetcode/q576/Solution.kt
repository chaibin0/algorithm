package leetcode.q576

class Solution {

    companion object {
        val positions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(-1, 0)
        )

        const val MODULO = 1000_000_000 + 7
    }

    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {

        val dp = Array(maxMove + 1) {
            Array(m) { LongArray(n) }
        }

        var answer = 0L

        dp[0][startRow][startColumn] = 1
        for (move in 0 until maxMove) {
            answer %= MODULO
            for (row in 0 until m) {
                answer %= MODULO
                for (column in 0 until n) {
                    answer %= MODULO
                    for ((positionRow, positionColumn) in positions) {
                        answer %= MODULO

                        val nextRow = row + positionRow
                        val nextColumn = column + positionColumn
                        if (nextRow < 0 || nextColumn < 0 || nextRow >= m || nextColumn >= n) {
                            answer += dp[move][row][column]
                            continue
                        }

                        dp[move + 1][nextRow][nextColumn] += (dp[move][row][column] % MODULO)
                    }
                }
            }
        }

        return (answer % MODULO).toInt()
    }
}
