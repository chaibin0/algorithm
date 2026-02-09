package leetcode.q490

class Solution {

    private val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0),
    )

    fun hasPath(maze: Array<IntArray>, start: IntArray, destination: IntArray): Boolean {
        val visited = mutableSetOf<Pair<Int, Int>>()

        val queue = ArrayDeque<Pair<Int, Int>>()

        val startPosition = Pair(start[0], start[1])
        queue.addLast(startPosition)
        visited.add(startPosition)

        while (queue.isNotEmpty()) {

            val (currentRow, currentColumn) = queue.removeFirst()
            if (currentRow == destination[0] && currentColumn == destination[1]) {
                return true
            }

            for ((directionRow, directionColumn) in directions) {
                var nextRow = currentRow
                var nextColumn = currentColumn

                while (
                    (nextRow + directionRow) >= 0 &&
                    (nextRow + directionRow) < maze.size &&
                    (nextColumn + directionColumn) >= 0 &&
                    (nextColumn + directionColumn) < maze[0].size &&
                    maze[nextRow + directionRow][nextColumn + directionColumn] != 1
                ) {
                    nextRow += directionRow
                    nextColumn += directionColumn
                }

                if (nextRow == currentRow && nextColumn == currentColumn) {
                    continue
                }

                val nextPosition = Pair(nextRow, nextColumn)
                if (visited.contains(nextPosition)) {
                    continue
                }

                visited.add(nextPosition)
                queue.addLast(nextPosition)
            }
        }

        return false
    }
}