package leetcode.q2047

class Solution {

    private val hyphen = '-'
    private val punctuationMarks = setOf('!', ',', '.')
    private val digits = setOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

    fun countValidWords(sentence: String): Int {
        var answer = 0

        sentence.split(" ")
            .filter { it.isNotBlank() }
            .forEach { word ->
                var hyphenCount = 0
                var punctuationCount = 0
                for ((index, char) in word.withIndex()) {
                    if (char == hyphen) {
                        hyphenCount++
                        if (index == 0 || index == word.lastIndex) {
                            return@forEach
                        }
                        if ((word.last() in punctuationMarks && index == word.lastIndex - 1)) {
                            return@forEach
                        }
                    } else if (char in punctuationMarks) {
                        punctuationCount++
                        if (index != word.lastIndex) {
                            return@forEach
                        }
                    } else if (char in digits) {
                        return@forEach
                    }
                }

                if (hyphenCount > 1) {
                    return@forEach
                }

                if (punctuationCount > 1) {
                    return@forEach
                }

                answer++
            }

        return answer
    }
}

/*
class Solution {
    fun countValidWords(sentence: String): Int {
        var answer = 0

        sentence.split(" ")
            .filter { it.isNotBlank() }
            .forEach { word ->
                if (word.matches(Regex("^[a-z]+(-[a-z]+)?[!,.]?$"))) {
                    answer++
                }
            }

        return answer
    }
}
 */