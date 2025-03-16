package leetcode.q351

import java.util.BitSet
import kotlin.math.max
import kotlin.math.min

class Solution {

    private var answer = 0

    fun numberOfPatterns(m: Int, n: Int): Int {
        val bit = BitSet(10)
        for (i in 1..9) {
            bit.set(i, true)
            dfs(bit, i, 1, m, n)
            bit.set(i, false)
        }
        return answer
    }

    private fun dfs(bit: BitSet, last: Int, currentSize: Int, m: Int, n: Int) {

        if (currentSize in m..n) {
            answer++
        }

        if (currentSize >= n) {
            return
        }

        for (next in 1..9) {
            if (validate(bit, last, next)) {
                bit.set(next, true)
                dfs(bit, next, currentSize + 1, m, n)
                bit.set(next, false)
            }
        }
    }

    private fun validate(bit: BitSet, lastNum: Int, nextNum: Int): Boolean {
        if (bit[nextNum]) {
            return false
        }

        val (lastNumX, lastNumY) = (lastNum - 1) % 3 to (lastNum - 1) / 3
        val (nextNumX, nextNumY) = (nextNum - 1) % 3 to (nextNum - 1) / 3
        val step = if (lastNumY == nextNumY) {
            1
        } else if (lastNumX == nextNumX) {
            3
        } else {
            val a = (nextNumY - lastNumY) / (nextNumX - lastNumX)
            when (a) {
                1 -> 4
                -1 -> 2
                else -> {
                    return true
                }
            }
        }

        val start = min(lastNum, nextNum) + step
        val end = max(lastNum, nextNum)

        for (i in start until end step step) {
            if (!bit[i]) {
                return false
            }
        }

        return true
    }
}