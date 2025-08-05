package baekjoon.q5949

fun main() {
    val N = readln()
    val sb = StringBuilder()

    var count = 0
    var length = N.length
    for (i in length - 1 downTo 0) {

        if (count == 3) {
            sb.append(',')
            count = 0
        }

        count++
        sb.append(N[i])
    }

    println(sb.reverse().toString())
}