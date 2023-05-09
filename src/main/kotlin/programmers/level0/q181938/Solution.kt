package programmers.level0.q181938

import kotlin.math.max

class Solution {
    fun solution(a: Int, b: Int): Int {
        return max(2 * a * b, (a.toString() + b.toString()).toInt())
    }
}