package leetcode.q1593

import kotlin.math.max

class Solution {

    private var answer = 0

    fun maxUniqueSplit(s: String): Int {
        dfs(0, "", mutableSetOf(), s)
        return answer
    }

    private fun dfs(index: Int, word: String, uniques: MutableSet<String>, s: String) {
        if (index == s.length) {
            answer = max(answer, uniques.size)
            return
        }

        val nextWord = word + s[index]
        dfs(index + 1, nextWord, uniques, s)
        if (!uniques.contains(nextWord)) {
            uniques.add(nextWord)
            dfs(index + 1, "", uniques, s)
            uniques.remove(nextWord)
        }
    }
}