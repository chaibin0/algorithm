package baekjoon.q5956

import kotlin.math.pow

fun main() {
    var (N, M) = readln().split(' ')
        .map { it.toInt() }

    var result = 0L
    var count = 0

    while (N > 0 && M > 0 && N % 2 != 0 && M % 2 != 0) {
        result += 4.0.pow(count.toDouble()).toLong()

        N = (N - 1) / 2
        M = (M - 1) / 2
        count++
    }


    println(result)
}
