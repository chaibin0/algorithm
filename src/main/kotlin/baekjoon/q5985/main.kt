package baekjoon.q5985

import kotlin.math.pow

var answer = 0L

fun main() {
    val n = readln().toInt()

    val length = 2.0.pow(n).toInt()
    val array = LongArray(length)

    for (i in 0 until length) {
        array[i] = readln().toLong()
    }


    dfs(0, length - 1, array)

    println(answer)
    array.forEach { println(it) }
}

fun dfs(start: Int, end: Int, array: LongArray) {

    if (start == end) {
        return
    }

    val mid = (start + end) / 2

    dfs(start, mid, array)
    dfs(mid + 1, end, array)

    var needChange = false
    if (array[start] > array[mid + 1]) {
        needChange = true
    }

    if (needChange) {
        for (i in 0 until (mid - start + 1)) {
            val swap = array[start + i]
            array[start + i] = array[mid + 1 + i]
            array[mid + 1 + i] = swap
        }

        answer += ((end - start + 1) * (end - start + 1)) / 2
    }
}
