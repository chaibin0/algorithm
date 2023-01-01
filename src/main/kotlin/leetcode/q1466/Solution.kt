package leetcode.q1466

typealias DIRECTION = Int

class Solution {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        var answer = 0
        val map: MutableMap<Int, MutableList<Pair<Int, DIRECTION>>> = HashMap()

        for ((from, end) in connections) {
            map.getOrPut(from) { arrayListOf() }.add(end to REVERSE)
            map.getOrPut(end) { arrayListOf() }.add(from to STRAIGHT)
        }
        val visit = BooleanArray(n)
        val queue: ArrayDeque<Int> = ArrayDeque()

        queue.addLast(0)
        visit[0] = true

        while (queue.isNotEmpty()) {
            val currentCity = queue.removeFirst()
            if (!map.containsKey(currentCity)) {
                continue
            }

            for ((nextCity, direction) in map[currentCity]!!) {
                if (visit[nextCity]) {
                    continue
                }

                if (direction == REVERSE) {
                    answer++
                }
                visit[nextCity] = true
                queue.add(nextCity)
            }
        }

        return answer
    }

    companion object {
        const val STRAIGHT = 0
        const val REVERSE = 1
    }
}