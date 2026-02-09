package leetcode.q3195

class Solution {
    fun countCompleteDayPairs(hours: IntArray): Long {
        var answer = 0L
        val map = mutableMapOf<Int, MutableList<Int>>()
        val keyMap = mutableMapOf<Int, Int>()
        for ((index, value) in hours.withIndex()) {
            val key = value % 24
            map.getOrPut(key) { mutableListOf() }.add(index)
        }

        for ((index, value) in hours.withIndex()) {
            val key = (24 - value % 24) % 24

            if (!map.containsKey(key)) {
                continue
            }

            val list = map[key]!!
            var i = keyMap[key] ?: 0

            while (i < list.size) {
                if (list[i] >= index) {
                    break
                }
                i++
            }
            keyMap[key] = i
            answer += (list.size - i)
        }

        return answer
    }
}