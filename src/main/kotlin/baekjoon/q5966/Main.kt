package baekjoon.q5966

fun main() {
    val n = readln().toInt()

    outer@ for (i in 0 until n) {
        val solution = readln().split(" ")
        val k = solution[0].toInt()
        val p = solution[1]

        val stack = ArrayDeque<Char>()
        for (j in 0 until k) {
            if (p[j] == '>') {
                stack.add(p[j])
                continue
            }

            val last = stack.removeLastOrNull()
            if (last == null) {
                println("illegal")
                continue@outer
            }
        }

        if (stack.isEmpty()) {
            println("legal")
        } else {
            println("illegal")
        }
    }
}