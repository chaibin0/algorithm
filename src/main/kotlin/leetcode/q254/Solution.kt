package leetcode.q254

class Solution {

    var n: Int = 0

    fun getFactors(n: Int): List<List<Int>> {
        this.n = n

        val end = n / 2
        val answers: MutableList<MutableList<Int>> = mutableListOf()

        for (i in 2 .. end) {

            if (n % i != 0) {
                continue
            }

            val remain = n / i
            if (remain < i) {
                break
            }
            val leftFactors = dfs(remain, i)
            for (left in leftFactors) {
                val answer = mutableListOf(i)
                answer.addAll(left)
                answers.add(answer)
            }
        }

        return answers
    }

    fun dfs(currentN: Int, min: Int): List<List<Int>> {

        val answers: MutableList<MutableList<Int>> = mutableListOf()

        val end = currentN / 2

        for (i in min..end) {

            if (currentN % i != 0) {
                continue
            }

            val remain = currentN / i
            if (remain < i) {
                break
            }
            val factors = dfs(remain, i)
            for (factor in factors) {
                val answer = mutableListOf(i)
                answer.addAll(factor)
                answers.add(answer)
            }
        }

        answers.add(mutableListOf(currentN))
        return answers
    }
}