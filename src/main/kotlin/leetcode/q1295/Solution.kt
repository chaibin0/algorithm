package leetcode.q1295

class Solution {
    fun findNumbers(nums: IntArray): Int {

        var answer = 0
        for (i in nums) {
            if (i.toString().length % 2 == 0) {
                answer++
            }
        }

        return answer
    }
}