package leetcode.q1436

class Solution {
    fun destCity(paths: List<List<String>>): String {
        val map = mutableMapOf<String, String>()
        paths.forEach {
            map[it[0]] = it[1]
        }

        var current = paths[0][0]
        while (map.containsKey(current)) {
            current = map[current]!!
        }
        return current
    }
}