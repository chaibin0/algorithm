package leetcode.q3135

import kotlin.math.max

class Solution {
    fun minOperations(initial: String, target: String): Int {

        val end = initial.length + target.length - 1
        var maxDuplicate = 0
        for (i in 1..end) {

            var currentDuplicate = 0
            for (j in initial.indices) {
                val rightPosition = i - initial.length + j

                if (rightPosition >= target.length) {
                    break
                }

                if (rightPosition < 0) {
                    continue
                }

                if (initial[j] != target[rightPosition]) {
                    maxDuplicate = max(maxDuplicate, currentDuplicate)
                    currentDuplicate = 0
                    continue
                }

                currentDuplicate++
            }

            maxDuplicate = max(maxDuplicate, currentDuplicate)
        }

        return initial.length - maxDuplicate + target.length - maxDuplicate
    }
}