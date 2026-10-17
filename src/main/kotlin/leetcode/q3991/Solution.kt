package leetcode.q3991

class Solution {
    val visited = mutableSetOf<List<Int>>()

    fun sortArray(nums: IntArray, pre: IntArray): Int {
        if (isValid(nums.toList())) {
            return 0
        }
        val queue = ArrayDeque<Pair<List<Int>, Int>>()
        queue.addLast(Pair(nums.toList(), 0))
        visited.add(nums.toList())
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            for (currentPre in pre) {
                val reversed = reversal(current.first, currentPre)
                if (isValid(reversed)) {
                    return current.second + 1
                }
                if (!visited.contains(reversed)) {
                    visited.add(reversed)
                    queue.addLast(Pair(reversed, current.second + 1))
                }
            }
        }

        return -1
    }

    fun reversal(nums: List<Int>, prefix: Int): List<Int> {
        val result = Array(nums.size) { -1 }
        for (i in 0 until prefix) {
            result[i] = nums[prefix - i - 1]
        }

        for (i in prefix until nums.size) {
            result[i] = nums[i]
        }

        return result.toList()
    }

    fun isValid(nums: List<Int>): Boolean {
        nums.forEachIndexed { index, i ->
            if (index != i) {
                return false
            }
        }
        return true
    }
}
