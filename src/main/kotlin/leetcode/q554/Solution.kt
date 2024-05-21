package leetcode.q554

class Solution {
    fun leastBricks(wall: List<List<Int>>): Int {
        val n = wall.size
        val map = mutableMapOf<Long, Int>()
        val sum = wall[0].sumOf { it.toLong() }

        for (row in wall) {
            var value = 0L
            for (height in row) {
                value += height
                if (value == sum) {
                    continue
                }
                map[value] = (map[value] ?: 0) + 1
            }
        }

        if (map.isEmpty()) {
            return n
        }

        var maxCount = 0
        for (count in map.values) {
            if (maxCount < count) {
                maxCount = count
            }
        }

        return n - maxCount
    }
}