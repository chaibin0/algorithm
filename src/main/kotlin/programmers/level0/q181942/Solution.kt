package programmers.level0.q181942


class Solution {
    fun solution(str1: String, str2: String): String {
        val sb = StringBuilder()
        val length = str1.length
        for(i in 0 until length){
            sb.append(str1[i])
            sb.append(str2[i])
        }
        return sb.toString()
    }
}