package programmers.level0.q181900

class Solution {
    fun solution(my_string: String, indices: IntArray): String {
        val arr = my_string.toCharArray()
        for (i in indices) {
            arr[i] = ' '
        }

        val sb = StringBuilder()
        for (s in my_string) {
            if (s == ' ') {
                continue
            }
            sb.append(s)
        }


        return sb.toString()
    }
}