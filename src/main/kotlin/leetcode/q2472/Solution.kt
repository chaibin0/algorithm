package leetcode.q2472

class Solution {
    fun maxPalindromes(s: String, k: Int): Int {
        var answer = 0
        var list = List<MutableList<Int>>(26) { mutableListOf() }

        if (k == 1) {
            return s.length
        }

        outer@ for ((index, value) in s.withIndex()) {
            val indexList = list[value - 'a']
            if (indexList.isEmpty()) {
                indexList.add(index)
                continue
            }

            for (startIndex in indexList) {
                if ((index - startIndex + 1) < k) {
                    break
                }

                if (checkPalindrome(s, startIndex, index)) {
                    answer++
                    list = List(26) { mutableListOf() }
                    continue@outer
                }
            }

            indexList.add(index)
        }

        return answer
    }

    private fun checkPalindrome(s: String, start: Int, end: Int): Boolean {
        val length = (start + end) / 2
        for (i in start..length) {
            if (s[i] != s[end - i + start]) {
                return false
            }
        }
        return true
    }
}