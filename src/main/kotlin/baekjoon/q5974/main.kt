package baekjoon.q5974

import kotlin.math.abs

fun main() {
    val (l, c, n) = readln().split(' ').map { it.toInt() }

    for (i in 0 until c) {
        val (si, pi) = readln().split(' ').map { it.toInt() }

        println(abs(pi - n) + si)
    }
}