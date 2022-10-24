package leetcode.q392

class Solution {
    fun isSubsequence(s: String, t: String): Boolean {

        var index = 0
        if (s.isNullOrEmpty()) {
            return true
        }

        for (c in t) {
            if (index == s.length) {
                return true
            }

            if (s[index] == c) {
                index++
            }
        }

        return index == s.length
    }
}