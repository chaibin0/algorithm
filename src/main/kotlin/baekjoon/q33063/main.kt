package baekjoon.q33063

fun main() {

    val (n, q) = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf<Triple<Int, Int, Int>, Int>()

    var answer = 0

    repeat(q) { i ->
        val (x, y, z) = readln().split(" ").map { it.toInt() + 1 }

        Triple(x, y, 0).let {
            map[it] = map.getOrDefault(it, 0) + 1
            if (map[it] == n) {
                answer++
            }
        }

        Triple(x, 0, z).let {
            map[it] = map.getOrDefault(it, 0) + 1
            if (map[it] == n) {
                answer++
            }
        }

        Triple(0, y, z).let {
            map[it] = map.getOrDefault(it, 0) + 1
            if (map[it] == n) {
                answer++
            }
        }

        println(answer)
    }
}