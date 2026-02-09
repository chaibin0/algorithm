package leetcode.q361

class Solution {

    fun maxKilledEnemies(grid: Array<CharArray>): Int {
        val visit = Array(2) {
            Array(grid.size) {
                BooleanArray(grid[0].size)
            }
        }

        val dp = Array(grid.size) { IntArray(grid[0].size) }

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] != '0') {
                    continue
                }

                if (!visit[0][i][j]) {
                    var enemy = 0
                    for (w in j + 1..grid[0].lastIndex) {
                        if (grid[i][w] == 'W') {
                            break
                        }

                        if (grid[i][w] == 'E') {
                            enemy++
                        }
                    }

                    for (w in j - 1 downTo 0) {
                        if (grid[i][w] == 'W') {
                            break
                        }

                        if (grid[i][w] == 'E') {
                            enemy++
                        }
                    }

                    for (w in j..grid[0].lastIndex) {
                        if (grid[i][w] == 'W') {
                            break
                        }

                        if (grid[i][w] == '0') {
                            visit[0][i][w] = true
                            dp[i][w] += enemy
                        }
                    }

                    for (w in j - 1 downTo 0) {
                        if (grid[i][w] == 'W') {
                            break
                        }

                        if (grid[i][w] == '0') {
                            visit[0][i][w] = true
                            dp[i][w] += enemy
                        }
                    }
                }

                if (!visit[1][i][j]) {
                    var enemy = 0
                    for (h in i + 1..grid.lastIndex) {
                        if (grid[h][j] == 'W') {
                            break
                        }

                        if (grid[h][j] == 'E') {
                            enemy++
                        }
                    }

                    for (h in i - 1 downTo 0) {
                        if (grid[h][j] == 'W') {
                            break
                        }

                        if (grid[h][j] == 'E') {
                            enemy++
                        }
                    }

                    for (h in i..grid.lastIndex) {
                        if (grid[h][j] == 'W') {
                            break
                        }
                        if (grid[h][j] == '0') {
                            visit[1][h][j] = true
                            dp[h][j] += enemy
                        }
                    }

                    for (h in i - 1 downTo 0) {
                        if (grid[h][j] == 'W') {
                            break
                        }
                        if (grid[h][j] == '0') {
                            visit[1][h][j] = true
                            dp[h][j] += enemy
                        }
                    }
                }
            }
        }
        var answer = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                answer = maxOf(answer, dp[i][j])
            }
        }

        return answer
    }
}