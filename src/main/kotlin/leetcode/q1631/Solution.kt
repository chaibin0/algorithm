package leetcode.q1631

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Solution {
    companion object {
        private val POSITIONS: Array<IntArray> = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )
    }

    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val rows = heights.size
        val columns = heights[0].size

        var low = 1_000_000 + 1
        var high = 0

        for (height in heights) {
            for (h in height) {
                low = min(low, h)
                high = max(high, h)
            }
        }

        high -= low
        low = 0

        var answer = high

        while (low <= high) {

            val mid = (low + high) / 2

            val queue = ArrayDeque<Pair<Int, Int>>()
            val visited = Array(rows) {
                BooleanArray(columns)
            }

            queue.addLast(0 to 0)
            visited[0][0] = true
            var isPossible = false

            outer@ while (queue.isNotEmpty()) {
                val (row, col) = queue.removeFirst()

                for ((r, c) in POSITIONS) {
                    val nextRow = row + r
                    val nextCol = col + c

                    if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= columns) {
                        continue
                    }

                    if (visited[nextRow][nextCol]) {
                        continue
                    }

                    val difference = heights[row][col] - heights[nextRow][nextCol]
                    if (abs(difference) > mid) {
                        continue
                    }

                    if ((nextRow == rows - 1) && (nextCol == columns - 1)) {
                        isPossible = true
                        break@outer
                    }

                    visited[nextRow][nextCol] = true
                    queue.add(nextRow to nextCol)
                }
            }

            if (isPossible) {
                answer = min(answer, mid)
                high = mid - 1
            } else {
                low = mid + 1
            }
        }

        return answer
    }
}