package programmers.level0.q181887

import kotlin.math.max

class Solution {
    fun solution(num_list: IntArray): Int {
        val (totalEven, totalOdd) = num_list.mapIndexed { index, e ->
            if (index % 2 == 1) {
                e to 0
            } else {
                0 to e
            }
        }.reduce { (sumEven, sumOdd), (even, odd) -> sumEven + even to sumOdd + odd }

        return max(totalEven, totalOdd)
    }
}