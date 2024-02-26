package leetcode.q758

class Solution {
    fun boldWords(words: Array<String>, s: String): String {

        val openList = IntArray(s.length + 1)
        val closeList = IntArray(s.length + 1)
        val sLength = s.length
        for (word in words) {
            val wordLength = word.length
            for (i in 0.rangeTo(sLength - wordLength)) {
                val value = s.substring(i, i + wordLength)
                if (word == value) {
                    openList[i]++
                    closeList[i + wordLength]++
                }
            }
        }

        var stack = 0
        val sb = StringBuilder()
        for (i in s.indices) {

            if (closeList[i] != 0 && openList[i] != 0) {
                stack += openList[i]
                stack -= closeList[i]
                sb.append(s[i])
                continue
            }

            if (openList[i] != 0) {
                if (stack != 0) {
                    stack += openList[i]
                } else {
                    sb.append("<b>")
                    stack += openList[i]
                }
            }

            if (closeList[i] != 0) {
                stack -= closeList[i]
                if (stack == 0) {
                    sb.append("</b>")
                }
            }

            sb.append(s[i])
        }

        if (closeList[s.length] != 0) {
            sb.append("</b>")
        }

        return sb.toString()
    }
}