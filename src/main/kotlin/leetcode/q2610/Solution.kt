package leetcode.q2610

class Solution {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        nums.sort()

        val answer = mutableListOf<MutableList<Int>>()
        var current = 0
        var answerIndex = 0
        for (num in nums) {
            if (current != num) {
                current = num
                answerIndex = 0
            }

            if (answer.lastIndex < answerIndex) {
                answer.add(mutableListOf())
            }

            answer[answerIndex].add(num)
            answerIndex++
        }

        return answer
    }
}