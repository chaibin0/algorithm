package leetcode.q2396

class Solution {
    fun isStrictlyPalindromic(n: Int): Boolean {
        val lastBase = n - 2

        for (b in 2..lastBase) {

            val s = StringBuilder()
            val num = n.toString(b)
            val length = num.length / 2
            for (i in 0 until length) {
                if (num[i] != num[num.lastIndex - i]) {
                    return false
                }
            }
        }

        return true
    }
}