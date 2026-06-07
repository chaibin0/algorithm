package leetcode.q2033

import kotlin.math.abs

class Solution {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val list = grid.flatMap { it.asIterable() }
            .toMutableList()

        val mod = list[0] % x

        list.find { mod != it % x }?.let { return -1 }

        list.sort()

        val mid = list[list.size / 2]
        return list.sumOf { abs(it - mid) / x }
    }
}