package programmers.q5968

import kotlin.math.abs

fun main() {
    val (k, h, l) = readln().split(' ').map { it.toInt() }

    val width = k * 2 - 1
    val height = (k * 2 - 1) * 2 - 1

    val hexagon = Array(height) {
        IntArray(width)
    }

    var number = 1
    var startHeight = 0
    var startWidth = 0

    for (i in 0 until width) {
        val p = abs(k - i - 1)
        val length = k * 2 - p - 1
        for (j in 0 until length) {
            hexagon[p + j * 2][i] = number
            if (number == h) {
                startHeight = p + j * 2
                startWidth = i
            }
            number++
        }
    }

    val positions = arrayOf(
        intArrayOf(-2, 0),
        intArrayOf(2, 0),
        intArrayOf(1, -1),
        intArrayOf(1, 1),
        intArrayOf(-1, 1),
        intArrayOf(-1, -1)
    )
    val answer = mutableListOf<Int>()
    val visit = Array(height) { BooleanArray(width) }
    val queue = ArrayDeque<Triple<Int, Int, Int>>()
    visit[startHeight][startWidth] = true
    queue.addLast(Triple(startHeight, startWidth, 0))

    while (queue.isNotEmpty()) {
        val (currentHeight, currentWidth, currentDistance) = queue.removeFirst()
        for ((positionHeight, positionWidth) in positions) {

            val nextHeight = currentHeight + positionHeight
            val nextWidth = currentWidth + positionWidth
            if (nextHeight >= height || nextWidth >= width || nextHeight < 0 || nextWidth < 0 ||
                visit[nextHeight][nextWidth] || hexagon[nextHeight][nextWidth] == 0
            ) {
                continue
            }

            visit[nextHeight][nextWidth] = true
            if (currentDistance + 1 == l) {
                answer.add(hexagon[nextHeight][nextWidth])
                continue
            }

            queue.addLast(Triple(nextHeight, nextWidth, currentDistance + 1))
        }
    }
    println(answer.size)
    answer.sorted().forEach { println(it) }
}