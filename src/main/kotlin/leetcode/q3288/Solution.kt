package leetcode.q3288

import kotlin.math.max

class Solution {
    fun maxPathLength(coordinates: Array<IntArray>, k: Int): Int {

        return max(maxPathLength(coordinates, k, true), maxPathLength(coordinates, k, false))
    }

    private fun maxPathLength(coordinates: Array<IntArray>, k: Int, isXOrder: Boolean): Int {

        val sortedBy = if (isXOrder) {
            coordinates.sortedWith(compareBy({ it[0] }, { it[1] }))
        } else {
            coordinates.sortedWith(compareBy({ it[1] }, { it[0] }))
        }

        val kIndex = sortedBy.indexOf(coordinates[k])
        val (kX, kY) = coordinates[k]
        var (minX, minY) = Pair(-1, -1)
        var count = 1
        for (i in 0 until kIndex) {
            if (minX < sortedBy[i][0] && minY < sortedBy[i][1] &&
                sortedBy[i][0] < kX && sortedBy[i][1] < kY
            ) {
                count++
                minX = sortedBy[i][0]
                minY = sortedBy[i][1]
                continue
            }
        }

        minX = coordinates[k][0]
        minY = coordinates[k][1]
        for (i in (kIndex + 1) until coordinates.size) {
            if (minX < sortedBy[i][0] && minY < sortedBy[i][1] &&
                sortedBy[i][0] > kX && sortedBy[i][1] > kY
            ) {
                count++
                minX = sortedBy[i][0]
                minY = sortedBy[i][1]
                continue
            }
        }

        return count
    }
}