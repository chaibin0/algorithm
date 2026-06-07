package leetcode.q3675

class Solution {
    fun minOperations(s: String): Int {
        val max = s.filterNot { it == 'a' }
            .minOrNull() ?: 'a'

        if (max == 'a') {
            return 0
        }

        return ('z' - max + 1)
    }
}
