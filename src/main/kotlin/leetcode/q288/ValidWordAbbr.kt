package leetcode.q288

class ValidWordAbbr {
    val abbrSet = mutableMapOf<String, Int>()
    val wordSet = mutableSetOf<String>()

    constructor(dictionary: Array<String>) {
        for (dict in dictionary) {

            if (wordSet.contains(dict)) {
                continue
            }

            if (dict.length == 1) {
                continue
            }

            wordSet.add(dict)
            val abbr = dict.first() + (dict.length - 2).toString() + dict.last()
            abbrSet[abbr] = abbrSet.getOrDefault(abbr, 0) + 1
        }
    }

    fun isUnique(word: String): Boolean {
        if (word.length == 1) {
            return true
        }

        val abbr = word.first() + (word.length - 2).toString() + word.last()

        if (word in wordSet && abbrSet[abbr] == 1) {
            return true
        }

        if (abbrSet.contains(abbr)) {
            return false
        }

        return true
    }
}