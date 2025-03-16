package leetcode.q1347

class Solution {
    fun minSteps(s: String, t: String): Int {
        val sAlphabets = IntArray(26) { 0 }
        val tAlphabets = IntArray(26) { 0 }

        for (char in s) {
            sAlphabets[char - 'a']++
        }
        for (char in t) {
            tAlphabets[char - 'a']++
        }


        var answer = 0
        for (i in 0 until 26) {
            val sAlphabetSize = sAlphabets[i]
            val tAlphabetSize = tAlphabets[i]

            if (sAlphabetSize > tAlphabetSize) {
                answer += (sAlphabetSize - tAlphabetSize)
            }
        }

        return answer
    }
}
