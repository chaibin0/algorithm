package baekjoon.q5959

import kotlin.math.abs

fun main() {

    val n = readLine()!!.toInt()
    val result = IntArray(n) { 0 }
    val list = mutableListOf<Triple<Int, Int, Int>>()

    (0 until n).forEach { i ->
        val (x, y, r) = readln().split(" ").map { it.toInt() }
        list.add(Triple(x, y, r))
    }

    for (i in 0 until n) {
        val (x1, y1, r1) = list[i]

        for (j in i + 1 until n) {
            val (x2, y2, r2) = list[j]

            val distance = abs(x1 - x2) * abs(x1 - x2) + abs(y1 - y2) * abs(y1 - y2)
            val r = (r1 + r2) * (r1 + r2)
            if (distance < r) {
                result[i]++
                result[j]++
            }
        }
    }

    result.forEach { println(it) }
}