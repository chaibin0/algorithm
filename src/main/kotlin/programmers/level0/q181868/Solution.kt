package programmers.level0.q181868

class Solution {
    fun solution(my_string: String): Array<String> {

        return my_string.split(" ").filter {
            it != null && it != ""
        }.toTypedArray()
    }
}