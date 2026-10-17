package leetcode.q1291

class Solution {

    private val answers = mutableListOf<Int>()
    fun sequentialDigits(low: Int, high: Int): List<Int> {

        (1..9).forEach { dfs(it, low, high) }
        return answers.sorted()
    }

    tailrec fun dfs(current: Int, low: Int, high: Int) {
        if (current > high) {
            return
        }

        if (current in low..high) {
            answers.add(current)
        }

        if (current % 10 + 1 > 9) {
            return
        }

        dfs(current * 10 + (current % 10 + 1), low, high)
    }
}