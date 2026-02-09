package baekjoon.q5986


fun main() {
    val n = readln().toInt()
    val space = Array(n) {
        Array(n) {
            BooleanArray(n)
        }
    }

    val visit = Array(n) {
        Array(n) {
            BooleanArray(n)
        }
    }

    var first = 0
    var second = 0
    val size = n * n
    (0 until size).forEach { i ->
        val array = readln().toCharArray().map { it == '*' }.toBooleanArray()
        space[first][second] = array
        second++
        if (second == n) {
            first++
            second = 0
        }
    }

    val directions = arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(0, -1, 0),
        intArrayOf(1, 0, 0),
        intArrayOf(-1, 0, 0),
        intArrayOf(0, 0, 1),
        intArrayOf(0, 0, -1),
    )

    var answer = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            for (k in 0 until n) {
                if (visit[i][j][k] || !space[i][j][k]) {
                    continue
                }
                answer++
                visit[i][j][k] = true
                val queue = ArrayDeque<Triple<Int, Int, Int>>()
                queue.add(Triple(i, j, k))
                while (queue.isNotEmpty()) {
                    val (currentI, currentJ, currentK) = queue.removeFirst()
                    for ((directionI, directionJ, directionK) in directions) {
                        val nextI = currentI + directionI
                        val nextJ = currentJ + directionJ
                        val nextK = currentK + directionK

                        if (nextI < 0 || nextJ < 0 || nextK < 0 || nextI >= n || nextJ >= n || nextK >= n) {
                            continue
                        }

                        if (visit[nextI][nextJ][nextK] || !space[nextI][nextJ][nextK]) {
                            continue
                        }
                        visit[nextI][nextJ][nextK] = true
                        queue.add(Triple(nextI, nextJ, nextK))
                    }
                }
            }
        }
    }

    println(answer)
}