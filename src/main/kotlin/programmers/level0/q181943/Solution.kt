package programmers.level0.q181943

class Solution {
    fun solution(my_string: String, overwrite_string: String, s: Int): String {
        val sb = StringBuilder()
        sb.append(my_string.subSequence(0, s))
        sb.append(overwrite_string)
        if (my_string.length > (s + overwrite_string.length)) {
            sb.append(my_string.subSequence(s + overwrite_string.length, my_string.length))
        }
        return sb.toString()
    }
}