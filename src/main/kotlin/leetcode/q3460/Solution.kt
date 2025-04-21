package leetcode.q3460

class Solution {
    fun longestCommonPrefix(s: String, t: String): Int {

        var sPos = 0
        var tPos = 0
        var answer = 0
        var isRemoved = false
        while (sPos < s.length && tPos < t.length) {

            if (s[sPos] == t[tPos]) {
                answer++
                sPos++
                tPos++
                continue
            }

            if (isRemoved) {
                break
            }

            sPos++
            isRemoved = true
        }

        return answer
    }
}