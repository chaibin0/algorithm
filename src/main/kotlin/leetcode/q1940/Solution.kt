package leetcode.q1940

class Solution {
    fun longestCommonSubsequence(arrays: Array<IntArray>): List<Int> {
        val map = sortedMapOf<Int, Int>()
        val size = arrays.size
        for (array in arrays) {
            for (num in array) {
                map[num] = map[num]?.let { it + 1 } ?: 1
            }
        }

        val answer = mutableListOf<Int>()
        map.entries.forEach {
            if (it.value == size) {
                answer.add(it.key)
            }
        }

        return answer
    }
}

