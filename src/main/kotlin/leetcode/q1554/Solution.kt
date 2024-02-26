package leetcode.q1554


class Solution {
    fun differByOne(dict: Array<String>): Boolean {

        if (dict.isEmpty()) {
            return false
        }

        val n = dict[0].length
        val set = mutableSetOf<String>()
        for (i in 0 until n) {
            for (word in dict) {
                val newWord = word.toCharArray()
                newWord[i] = '*'
                val newWordString = String(newWord)

                if (set.contains(newWordString)) {
                    return true
                }

                set.add(String(newWord))
            }
        }

        return false
    }
}