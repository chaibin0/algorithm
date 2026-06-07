package leetcode.q1310

class Solution {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        val answers = IntArray(queries.size) { 0 }
        val prefixSum = IntArray(arr.size + 1) { 0 }
        var current = 0
        for ((index, value) in arr.withIndex()) {
            current = current.xor(value)
            prefixSum[index + 1] = current
        }

        for ((index, query) in queries.withIndex()) {
            val (left, right) = query
            if(left == right) {
                answers[index] = arr[left]
                continue
            }
            answers[index] = prefixSum[right + 1].xor(prefixSum[left])
        }

        return answers
    }
}