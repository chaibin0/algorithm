package leetcode.q2244

class Solution {
    fun minimumRounds(tasks: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        for (task in tasks) {
            if (!map.containsKey(task)) {
                map[task] = 0
            }
            map[task] = map[task]!! + 1
        }

        var answer = 0
        for (value in map.values) {
            if (value == 1) {
                return -1
            }

            if (value % 3 == 1) {
                answer += value / 3 + 1
                continue
            }

            answer += value / 3
            answer += (value % 3) / 2
        }

        return answer
    }
}