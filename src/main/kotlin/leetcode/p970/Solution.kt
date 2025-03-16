package leetcode.p970

class Solution {

    val set = mutableSetOf<Int>()
    val visited = mutableSetOf<Pair<Long, Long>>()

    fun powerfulIntegers(x: Int, y: Int, bound: Int): List<Int> {
        dfs(x, y, 1, 1, bound)
        return set.toList()
    }

    fun dfs(x: Int, y: Int, currentX: Long, currentY: Long, bound: Int) {
        val sum = currentX + currentY

        if (sum > bound) {
            return
        }
        if (visited.contains(currentX to currentY)) {
            return
        }
        visited.add(currentX to currentY)
        set.add(sum.toInt())
        dfs(x, y, currentX * x, currentY, bound)
        dfs(x, y, currentX, currentY * y, bound)
    }
}