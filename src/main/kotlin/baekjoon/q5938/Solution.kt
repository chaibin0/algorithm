package baekjoon.q5938

fun main() {
    val (N, M) = readlnOrNull()!!
        .split(" ")
        .map { it.toInt() }

    val graph = Array(N + 1) { BooleanArray(N + 1) }
    val lists = IntArray(N + 1) { it }  //  1, 2, 3, 4, 5, 6
    val visited = BooleanArray(N + 1) { false } // false, false, false, false, false


    for (i in 0 until M) {
        val (left, right) = readlnOrNull()!!
            .split(" ")
            .map { it.toInt() }

        graph[left][right] = true
        graph[right][left] = true
    }

    visited[1] = true

    val queue = ArrayDeque<Int>()
    queue.addLast(1)

    while (queue.isNotEmpty()) {
        val currentLeft = queue.removeFirst()
        for (i in 1..N) {
            if (!graph[currentLeft][i] || visited[i]) {
                continue
            }

            lists[i] = 1
            visited[i] = true
            queue.addLast(i)
        }
    }

    var isAllConnected = true
    for (i in 2..N) {
        if (lists[i] != 1) {
            isAllConnected = false
            println(i)
        }
    }

    if(isAllConnected){
        println(0)
    }
}