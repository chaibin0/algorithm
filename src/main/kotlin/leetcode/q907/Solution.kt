package leetcode.q907

class Solution {

    fun sumSubarrayMins(arr: IntArray): Int {
        var answer = 0L
        val stacks = LongArray(arr.size + 1)

        for ((index, value) in arr.withIndex()) {
            var k = 1
            while (index - k >= 0 && arr[index - k] > value) {
                k++
            }

            stacks[index + 1] = (stacks[index - k + 1] + k * value) % MOD
            answer += stacks[index + 1] % MOD
        }

        return (answer % MOD).toInt()
    }

    companion object {
        const val MOD = 1000_000_000 + 7
    }
}