package leetcode.q934

import java.util.*

private val DIRECTIONS = arrayOf(
    intArrayOf(-1, 0),
    intArrayOf(0, 1),
    intArrayOf(1, 0),
    intArrayOf(0, -1)
)

class Solution {
    fun shortestBridge(grid: Array<IntArray>): Int {
        val n = grid.size

        first@ for (row in grid.indices) {
            for (column in grid.indices) {
                if (grid[row][column] == 1) {
                    fillBridge(grid, row, column)
                    break@first
                }
            }
        }

        val queue: Queue<IntArray> = ArrayDeque()
        val graph = Array(n) { IntArray(n) }
        val visit = Array(n) { BooleanArray(n) }
        for (row in grid.indices) {
            for (column in grid.indices) {
                if (grid[row][column] == -1) {
                    visit[row][column] = true
                    queue.add(intArrayOf(row, column))
                }
            }
        }

        while (!queue.isEmpty()) {

            val current = queue.poll()

            for (direction in DIRECTIONS) {
                val nextRow = current[0] + direction[0]
                val nextColumn = current[1] + direction[1]
                if (nextRow < 0 || nextColumn < 0 || nextRow >= n || nextColumn >= n) {
                    continue
                }

                if (visit[nextRow][nextColumn] || grid[nextRow][nextColumn] == -1) {
                    continue
                }

                if (grid[nextRow][nextColumn] == 1) {
                    return graph[current[0]][current[1]]
                }

                graph[nextRow][nextColumn] = graph[current[0]][current[1]] + 1
                queue.add(intArrayOf(nextRow, nextColumn))
                visit[nextRow][nextColumn] = true
            }
        }

        return 0
    }

    private fun fillBridge(grid: Array<IntArray>, row: Int, column: Int) {
        val n = grid.size
        grid[row][column] = -1
        val queue: Queue<IntArray> = ArrayDeque()
        queue.add(intArrayOf(row, column))
        while (!queue.isEmpty()) {
            val current = queue.poll()
            for (direction in DIRECTIONS) {
                val nextRow = current[0] + direction[0]
                val nextColumn = current[1] + direction[1]
                if (nextRow < 0 || nextColumn < 0 || nextRow >= n || nextColumn >= n) {
                    continue
                }
                if (grid[nextRow][nextColumn] != 1) {
                    continue
                }
                grid[nextRow][nextColumn] = -1
                queue.add(intArrayOf(nextRow, nextColumn))
            }
        }
    }
}

fun main() {
//    val input: Array<IntArray> = arrayOf(
//        intArrayOf(1, 1, 1, 1, 1),
//        intArrayOf(1, 0, 0, 0, 1),
//        intArrayOf(1, 0, 1, 0, 1),
//        intArrayOf(1, 0, 0, 0, 1),
//        intArrayOf(1, 1, 1, 1, 1)
//    )

    val input: Array<IntArray> = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 1),
    )

    println(Solution().shortestBridge(input))
}