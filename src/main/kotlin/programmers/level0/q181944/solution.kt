package programmers.level0.q181944

fun main(args: Array<String>) {
    val a = readLine()!!.toInt()
    println("${a} is ${if (a % 2 == 0) "even" else "odd"}")
}