package programmers.level0.q181865

class Solution {
    fun solution(binomial: String): Int {
        var answer: Int = 0
        val (a, op, b) = binomial.split(" ")
        return when (op) {
            "-" -> a.toInt() - b.toInt()
            "+" -> a.toInt() + b.toInt()
            else -> a.toInt() * b.toInt()
        }
    }
}