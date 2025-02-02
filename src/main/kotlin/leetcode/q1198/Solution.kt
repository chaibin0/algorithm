package leetcode.q1198

import java.util.*

class Solution {
    fun smallestCommonElement(mat: Array<IntArray>): Int {

        var tm = TreeSet<Int>()
        for (column in mat[0]) {
            tm.add(column)
        }

        for (i in 1.until(mat.size)) {
            val newTm = TreeSet<Int>()
            for (column in mat[i]) {
                if (tm.contains(column)) {
                    newTm.add(column)
                }
            }

            tm = newTm
        }

        return if(tm.isNotEmpty()) tm.first() else -1
    }
}