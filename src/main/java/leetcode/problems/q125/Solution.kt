package leetcode.problems.q125

class Solution {
    fun isPalindrome(s: String): Boolean {
        val sb = StringBuilder()

        for (c in s) {
            if ((c in 'a'..'z') || (c in 'A'..'Z') || (c in '0'..'9')) {
                sb.append(c.lowercaseChar())
            }
        }

        if (sb.isBlank()) {
            return true
        }

        val length = sb.lastIndex / 2
        for (i in 0..length) {
            if (sb[i] != sb[sb.lastIndex - i]) {
                return false
            }
        }

        return true
    }
}