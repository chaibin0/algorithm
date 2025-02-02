package leetcode.q2645

class Solution {
    fun addMinimum(word: String): Int {
        var answer = 0
        val firstChar = word[0]
        val lastChar = word[word.lastIndex]
        var currentChar = firstChar

        when (firstChar) {
            'b' -> answer += 1
            'c' -> answer += 2
        }

        when (lastChar) {
            'a' -> answer += 2
            'b' -> answer += 1
        }

        for (i in 1 until word.length) {
            when (currentChar) {
                'a' -> when (word[i]) {
                    'a' -> answer += 2
                    'c' -> answer += 1
                }

                'b' -> when (word[i]) {
                    'a' -> answer += 1
                    'b' -> answer += 2
                }

                'c' -> when (word[i]) {
                    'b' -> answer += 1
                    'c' -> answer += 2
                }
            }
            currentChar = word[i]
        }

        return answer
    }
}