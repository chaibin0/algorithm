package leetcode.q1001

import kotlin.math.abs

class Solution {

    val position = arrayOf(
        intArrayOf(-1, -1),
        intArrayOf(-1, 0),
        intArrayOf(-1, 1),
        intArrayOf(0, -1),
        intArrayOf(0, 0),
        intArrayOf(0, 1),
        intArrayOf(1, -1),
        intArrayOf(1, 0),
        intArrayOf(1, 1),
    )

    fun gridIllumination(n: Int, lamps: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val set = mutableSetOf<Pair<Int, Int>>()
        lamps.forEach { (y, x) ->
            set.add(y to x)
        }

        val result = IntArray(queries.size)

        queries.forEachIndexed { index, current ->
            val currentY = current[0]
            val currentX = current[1]
            val isOn = set.any { (lampY, lampX) ->
                return@any currentY == lampY || currentX == lampX || abs(currentY - lampY) == abs(currentX - lampX)
            }
            result[index] = if (isOn) 1 else 0

            for (p in position) {
                val nextY = currentY + p[0]
                val nextX = currentX + p[1]
                if (nextY !in 0..<n || nextX !in 0..<n) {
                    continue
                }
                val index = nextY to nextX
                if (set.contains(index)) {
                    set.remove(index)
                }
            }
        }
        return result
    }
}