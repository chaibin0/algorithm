package leetcode.q2393

class Solution {

    fun countSubarrays(nums: IntArray): Long {

        var answer = 0L
        var current = mutableListOf<Int>()

        for (num in nums) {
            if (current.isEmpty() || current.last() < num) {
                current.add(num)
                continue
            }

            answer += (current.size.toLong() * (current.size + 1) / 2)
            current = mutableListOf(num)
        }

        if (current.isNotEmpty()) {
            answer += (current.size.toLong() * (current.size + 1) / 2)
        }

        return answer
    }
}


