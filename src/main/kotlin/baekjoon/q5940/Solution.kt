package baekjoon.q5940

import kotlin.math.pow

fun main() {
    val (A, B) = readln().split(" ")
        .map { it.toInt() }

    for (E in (A + 1)..62) {

        var eth = 2.toDouble().pow(E).toLong()
        var firstDigit = eth
        while (eth != 0L) {
            firstDigit = eth % 10
            eth /= 10
        }

        if (firstDigit == B.toLong()) {
            println(E)
            return
        }
    }

    println(0)
}