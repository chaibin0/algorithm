package leetcode.q489

import baekjoon.q5985.dfs

class Robot {

    // Returns true if the cell in front
    // Returns false if the cell in front
    fun move(): Boolean = true

    // Robot will stay in the same cell
    // Each turn will be 90 degrees.
    fun turnLeft() {}
    fun turnRight() {}

    // Clean the current cell.
    fun clean() {}
}

class Solution {
    val current = mutableSetOf<Pair<Int, Int>>()
    val position = arrayOf(
        intArrayOf(0, -1),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(1, 0),
    )
    var currentPosition = 0

    fun cleanRoom(robot: Robot) {
        robot.clean()
        current.add(Pair(0, 0))
        (0 until 4).forEach { _ ->
            dfs(robot)
            robot.turnLeft()
            currentPosition = (currentPosition + 1) % 4
        }
    }

    fun dfs(robot: Robot) {

        val result = robot.move()


        for (i in 0 until 4) {
            dfs(robot)
            robot.turnLeft()
            currentPosition = (currentPosition + 1) % 4
        }
    }
}