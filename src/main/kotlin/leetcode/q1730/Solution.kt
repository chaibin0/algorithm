package leetcode.q1730

import kotlin.collections.ArrayDeque

class Solution {

    companion object {
        val POSITIONS = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )
    }

    fun getFood(grid: Array<CharArray>): Int {

        val m = grid.size
        val n = grid[0].size

        val visited = Array(m) {
            BooleanArray(n)
        }
        val foodPosition = hashSetOf<Pair<Int, Int>>()

        val queue = ArrayDeque<Triple<Int, Int, Int>>()

        for ((heightIndex, width) in grid.withIndex()) {
            for ((widthIndex, widthValue) in width.withIndex()) {
                if (widthValue == '*') {
                    queue.addLast(Triple(heightIndex, widthIndex, 0))
                    visited[heightIndex][widthIndex] = true
                }

                if (widthValue == 'X') {
                    visited[heightIndex][widthIndex] = true
                }

                if (widthValue == '#') {
                    foodPosition.add(heightIndex to widthIndex)
                }
            }
        }

        while (queue.isNotEmpty()) {
            val (heightIndex, widthIndex, value) = queue.removeFirst()
            for ((heightPosition, widthPosition) in POSITIONS) {

                val nextHeightPosition = heightIndex + heightPosition
                val nextWidthPosition = widthIndex + widthPosition

                if (nextHeightPosition >= m ||
                    nextHeightPosition < 0 ||
                    nextWidthPosition >= n ||
                    nextWidthPosition < 0 ||
                    visited[nextHeightPosition][nextWidthPosition]
                ) {
                    continue
                }

                if (foodPosition.contains(Pair(nextHeightPosition, nextWidthPosition))) {
                    return value + 1
                }

                visited[nextHeightPosition][nextWidthPosition] = true
                queue.addLast(Triple(nextHeightPosition, nextWidthPosition, value + 1))
            }
        }

        return -1
    }
}