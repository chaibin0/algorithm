package leetcode.q1820

import kotlin.math.max

class Solution {

    var answer = 0

    fun maximumInvitations(grid: Array<IntArray>): Int {

        val n = grid[0].size
        val visited = BooleanArray(n) { false }
        grid.sortByDescending {
            it.sum()
        }

        val girlCount = IntArray(n) { 0 }
        for (girls in grid) {
            for ((index, girl) in girls.withIndex()) {
                if (girl == 1) {
                    girlCount[index]++
                }
            }
        }

        dfs(grid, visited, 0, girlCount, 0)
        return answer
    }

    private fun dfs(grid: Array<IntArray>, visited: BooleanArray, boy: Int, girlCount: IntArray, invitation: Int) {

        if (boy == grid.size) {
            answer = max(answer, invitation)
            return
        }

        var currentGirlIndex = -1
        for ((index, girl) in grid[boy].withIndex()) {
            if (visited[index] || girl == 0) {
                continue
            }

            if (currentGirlIndex == -1 || girlCount[currentGirlIndex] > girlCount[index]) {
                currentGirlIndex = index
            }
        }

        if (currentGirlIndex == -1) {
            dfs(grid, visited, boy + 1, girlCount, invitation)
            return
        }

        val minGirlCount = girlCount[currentGirlIndex]
        for ((index, girl) in grid[boy].withIndex()) {
            if (visited[index] || girl == 0) {
                continue
            }

            if (girlCount[index] == minGirlCount) {
                visited[index] = true
                dfs(grid, visited, boy + 1, girlCount, invitation + 1)
                visited[index] = false
            }
        }
    }
}