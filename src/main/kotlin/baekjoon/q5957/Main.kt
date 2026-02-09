package baekjoon.q5957

fun main() {
    val N = readln().toInt()

    val list = Array(3) {
        ArrayDeque<Int>()
    }

    for (i in N downTo 1) {
        list[0].add(i)
    }

    while (list[2].size != N) {

        val (process, count) = readln().split(" ").map { it.toInt() }
        (0 until count).forEach { i ->
            val dish = list[process - 1].removeLast()
            list[process].add(dish)
        }
    }

    while (list[2].isNotEmpty()) {
        println(list[2].removeLast())
    }
}