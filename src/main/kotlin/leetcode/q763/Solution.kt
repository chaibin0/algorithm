package leetcode.q763

class Solution {
    fun partitionLabels(s: String): List<Int> {
        val answer = mutableListOf<Int>()
        val alphabetSize = 26
        val lastPositions = IntArray(alphabetSize) { -1 }

        for ((index, value) in s.withIndex()) {
            lastPositions[value - 'a'] = index
        }

        var index = 0
        var nextIndex = index
        outer@ while (index < s.length) {

            val last = lastPositions[s[nextIndex] - 'a']
            for (i in (index + 1) until last) {
                if (lastPositions[s[i] - 'a'] > last) {
                    nextIndex = lastPositions[s[i] - 'a']
                    continue@outer
                }
            }
            answer.add(last - index + 1)
            index = last + 1
            nextIndex = index
        }

        return answer
    }
}