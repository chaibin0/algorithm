package leetcode.q140

class Solution {

    private lateinit var wordDictSet: Set<String>
    private lateinit var answers: MutableList<String>

    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        this.wordDictSet = wordDict.toSet()
        this.answers = mutableListOf()

        checkWordBreak(0, s, ArrayDeque())
        return answers
    }

    private fun checkWordBreak(index: Int, s: String, currentWords: ArrayDeque<String>) {

        if (index == s.length) {
            answers.add(currentWords.joinToString(" "))
            return
        }

        for (i in index + 1..s.length) {
            val sub = s.substring(index, i)
            if (wordDictSet.contains(sub)) {
                currentWords.addLast(sub)
                checkWordBreak(i, s, currentWords)
                currentWords.removeLast()
            }
        }
    }
}