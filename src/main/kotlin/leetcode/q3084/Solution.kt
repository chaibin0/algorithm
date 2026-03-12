package leetcode.q3084

class Solution {
    fun countSubstrings(s: String, c: Char): Long {

        var count = 0L
        for (sc in s) {
            if (sc == c) {
                count++
            }
        }
        return count + (count * (count - 1) / 2)
    }
}
