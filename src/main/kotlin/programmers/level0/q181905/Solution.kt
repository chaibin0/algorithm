package programmers.level0.q181905

class Solution {
    fun solution(my_string: String, s: Int, e: Int): String {
        return my_string.substring(0, s) + my_string.substring(s, e).reversed() + my_string.substring(e)
    }
}