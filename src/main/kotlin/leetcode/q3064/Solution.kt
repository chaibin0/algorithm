package leetcode.q3064


class Solution : Problem() {
    fun findNumber(): Int {
        var answer = 0
        var currentBinary = 1
        for (i in 0..31) {
            currentBinary = if (i == 0) 1 else currentBinary * 2
            if (commonSetBits(currentBinary) == 1) {
                answer += currentBinary
            }
        }
        return answer
    }
}

open class Problem() {
    private val n = 31

    fun commonSetBits(num: Int): Int {
        return n and num
    }
}
