package leetcode.q472

class Solution {

    private lateinit var wordsToSet: Set<String>

    fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {

        val answers = mutableListOf<String>()

        this.wordsToSet = words.toSet()
        for (word in words) {
            if (dfs(0, word, 0)) {
                answers.add(word)
            }
        }

        return answers
    }

    fun dfs(index: Int, word: String, count: Int): Boolean {

        if (index == word.length && count > 1) {
            return true
        }

        for (i in (index + 1)..word.length) {
            val sliceString = word.substring(index, i)

            if (sliceString == word) {
                return false
            }

            if (wordsToSet.contains(sliceString) &&
                dfs(i, word, count + 1)
            ) {
                return true
            }
        }

        return false
    }
}