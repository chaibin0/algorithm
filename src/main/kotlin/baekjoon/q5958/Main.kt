package baekjoon.q5958

fun main() {
    val N = readln().toInt()
    val graph = Array(N) { CharArray(N) }
    val visit = Array(N) { BooleanArray(N) }
    var answer = 0
    val directions = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1),
    )
    for (i in 0 until N) {
        graph[i] = readln().toCharArray()
    }

    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (graph[i][j] != '*') {
                continue
            }

            if (visit[i][j]) {
                continue
            }

            answer++
            visit[i][j] = true
            val queue = ArrayDeque<Pair<Int, Int>>()
            queue.addLast(Pair(i, j))
            while (queue.isNotEmpty()) {
                val (currentI, currentJ) = queue.removeFirst()
                for (direction in directions) {
                    val nextI = currentI + direction[0]
                    val nextJ = currentJ + direction[1]
                    if (nextI < 0 || nextJ < 0 || nextI >= N || nextJ >= N || visit[nextI][nextJ] || graph[nextI][nextJ] != '*') {
                        continue
                    }

                    visit[nextI][nextJ] = true
                    queue.addLast(Pair(nextI, nextJ))
                }
            }
        }
    }

    println(answer)
}