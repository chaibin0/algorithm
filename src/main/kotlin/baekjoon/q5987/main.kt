package baekjoon.q5987

fun main() {
    val z = readLine()!!.toInt()
    (0 until z).forEach { _ ->
        val (n, c, str) = readLine()!!.split(' ')
        solution(n.toInt(), c.toInt(), str)
    }
}

fun solution(n: Int, c: Int, str: String) {

    var answer = str
    (0 until c).forEach { _ ->
        val substring = answer.substring(n)
        answer = substring + answer
    }
    println(answer)
}
