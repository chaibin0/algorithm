package leetcode.q648

class Solution {
    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val dictionarySet = dictionary.toSet()
        val sentences = sentence.split(" ").map {
            val sb = StringBuilder()
            for (c in it) {
                sb.append(c)
                val root = sb.toString()
                if (dictionarySet.contains(root)) {
                    return@map root
                }
            }
            it
        }

        return sentences.joinToString(" ")
    }
}