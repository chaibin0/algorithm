package baekjoon.q5948

fun main() {
    var N = readln().toInt()
    var count = 1

    val set = mutableSetOf<Int>()
    set.add(N)
    while (N != 0) {
        val middle = (N % 1000) / 10

        val square = middle * middle
        if (set.contains(square)) {
            break
        }
        set.add(square)
        N = square
        count++
    }

    println(count)
}