package leetcode.q3015

class Solution {
    fun countOfPairs(n: Int, x: Int, y: Int): IntArray {
        val path = mutableListOf<MutableList<Int>>()
        val answer = IntArray(n)
        path.add(mutableListOf())

        for (i in 1..n) {

            val list = mutableListOf<Int>()
            if (i - 1 >= 1) {
                list.add(i - 1)
            }

            if (i + 1 <= n) {
                list.add(i + 1)
            }

            path.add(list)
        }

        if (x != y) {
            path[x].add(y)
            path[y].add(x)
        }

        for (i in 1..n) {
            val visited = BooleanArray(n + 1)
            visited[i] = true
            val queue = ArrayDeque<Pair<Int, Int>>()
            queue.add(i to 0)
            while (queue.isNotEmpty()) {
                val (current, count) = queue.removeFirst()
                for (connected in path[current]) {
                    if (visited[connected]) {
                        continue
                    }

                    visited[connected] = true
                    answer[count]++
                    queue.add(connected to count + 1)
                }
            }
        }

        return answer
    }
}
