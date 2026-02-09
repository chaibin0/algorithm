package baekjoon.q5984

fun main() {

    val n = readln().toInt()

    val array = (1..n).map { it }.toIntArray()
    var index = 0
    var currentCow = 1
    val visit = mutableSetOf<Int>()
    array[0] = 0
    visit.add(1)
    while (true) {
        index = (index + currentCow) % n
        if (index == 0) {
            break
        }
        val nextCow = array[index]
        if (visit.contains(nextCow)) {
            break
        }
        visit.add(nextCow)
        array[index] = currentCow
        currentCow = nextCow
    }

    println(currentCow)
}