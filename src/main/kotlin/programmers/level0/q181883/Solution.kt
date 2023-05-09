package programmers.level0.q181883

class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        val graph = IntArray(arr.size + 1)

        for ((start, end) in queries) {
            graph[start]++
            graph[end + 1]--
        }

        var current = 0
        for (index in arr.indices) {
            current += graph[index]
            arr[index] += current
        }

        return arr
    }
}