package leetcode.q134


class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var i = 0
        val length = gas.size * 2
        val size = gas.size
        var sum = 0
        var start = 0
        while (i < length && start < size) {

            sum += gas[i % size] - cost[i % size]
            if (sum < 0) {
                while (sum < 0 && start < size) {
                    sum -= (gas[start] - cost[start])
                    start++
                }

                i++
                continue
            }

            if (((i + 1) % size) == start) {
                break
            }

            i++
        }

        if (start == size) {
            return -1
        }

        return start
    }
}