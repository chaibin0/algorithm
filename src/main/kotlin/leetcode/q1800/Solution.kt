package leetcode.q1800

import kotlin.math.max

class Solution {
    fun maxAscendingSum(nums: IntArray): Int {

        var stack = ArrayList<Int>()

        var answer = 0
        for (num in nums) {
            if(!stack.isEmpty() && num <= stack.last()){
                answer = max(answer, stack.sum())
                stack = ArrayList()
            }
            stack.add(num)
        }

        return max(answer, stack.sum())
    }
}