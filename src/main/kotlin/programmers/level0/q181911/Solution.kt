package programmers.level0.q181911

class Solution {
    fun solution(my_strings: Array<String>, parts: Array<IntArray>): String {
        val sb = StringBuilder()
        for (i in parts.indices) {
            sb.append(my_strings[i].subSequence(parts[i][0], parts[i][1] + 1))
        }
        return sb.toString()
    }
}