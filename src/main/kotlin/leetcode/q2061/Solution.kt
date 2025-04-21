package leetcode.q2061


class Solution {

    companion object {
        val POSITIONS = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0),
        )
    }

    private var currentPosition = 0
    private var answer = 0
    private var visited = mutableSetOf<Triple<Int, Int, Int>>()

    fun numberOfCleanRooms(room: Array<IntArray>): Int {
        room[0][0] = -1
        answer++

        var currentTry = 0
        var currentRow = 0
        var currentColumn = 0

        while (currentTry < 4) {
            currentTry++

            val cache = Triple(currentRow, currentColumn, currentPosition)
            if (visited.contains(cache)) {
                return answer
            }
            visited.add(cache)

            val (row, column) = POSITIONS[currentPosition]
            val (nextRow, nextColumn) = (row + currentRow) to (column + currentColumn)
            if (nextRow < 0 || nextColumn < 0 ||
                nextRow >= room.size || nextColumn >= room[0].size ||
                room[nextRow][nextColumn] == 1
            ) {
                currentPosition = (currentPosition + 1) % 4
                continue
            }

            if (room[nextRow][nextColumn] == 0) {
                room[nextRow][nextColumn] = -1
                answer++
            }

            currentTry = 0
            currentRow = nextRow
            currentColumn = nextColumn
        }

        return answer
    }
}