package leetcode.q1926

import java.util.LinkedList
import java.util.Queue

private val DIRECTIONS = arrayOf(
    Position(1, 0),
    Position(-1, 0),
    Position(0, 1),
    Position(0, -1)
)

class Solution {
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {

        val m = maze.size
        val n = maze[0].size

        val dp = Array(m) { IntArray(n) }
        val visit = Array(m) { BooleanArray(n) }

        val queue: Queue<Position> = LinkedList()

        visit[entrance[0]][entrance[1]] = true
        queue.add(Position(entrance[0], entrance[1]))

        while (!queue.isEmpty()) {

            val current = queue.poll()

            for (direction in DIRECTIONS) {
                val nextRow = current.row + direction.row
                val nextColumn = current.column + direction.column

                if (nextRow < 0 || nextColumn < 0 || nextRow >= m || nextColumn >= n) {
                    continue
                }

                if (maze[nextRow][nextColumn] == '+') {
                    continue
                }

                if (visit[nextRow][nextColumn]) {
                    continue
                }

                if (nextRow == 0 || nextColumn == 0 || nextRow == m - 1 || nextColumn == n - 1) {
                    return dp[current.row][current.column] + 1
                }

                dp[nextRow][nextColumn] = dp[current.row][current.column] + 1
                visit[nextRow][nextColumn] = true
                queue.add(Position(nextRow, nextColumn))
            }
        }

        return -1
    }
}

data class Position(val row: Int, val column: Int)