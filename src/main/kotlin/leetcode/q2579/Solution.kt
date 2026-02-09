package leetcode.q2579

class Solution {
    fun coloredCells(n: Int): Long {
        val k = n.toLong()
        return 2 * k * k - 2 * k + 1
    }
}