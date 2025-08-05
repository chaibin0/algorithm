package baekjoon.q5939

import java.util.*

fun main() {
    val N = readlnOrNull()!!.toInt()
    val queue = PriorityQueue<Triple<Int, Int, Int>>(Comparator { o1, o2 ->
        if (o1.first != o2.first) {
            return@Comparator o1.first - o2.first
        } else if (o1.second != o2.second) {
            return@Comparator o1.second - o2.second
        }
        return@Comparator o1.third - o2.third
    })

    for (i in 1..N) {
        val (hour, minute, second) = readlnOrNull()!!
            .split(" ")
            .map { it.toInt() }

        queue.add(Triple(hour, minute, second))
    }

    while (queue.isNotEmpty()) {
        val (hour, minute, second) = queue.remove()
        println("$hour $minute $second")
    }
}
