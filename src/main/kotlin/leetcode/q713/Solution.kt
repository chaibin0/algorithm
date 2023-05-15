package leetcode.q713

class Solution {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {

        if(k == 0){
            return 0
        }

        val dq = ArrayDeque<Int>()

        var answer = 0
        var productOfAll = 1L
        for (num in nums) {

            if(num >= k){
                while (dq.isNotEmpty()) {
                    answer += dq.size
                    dq.removeFirst()
                }

                productOfAll = 1L
                continue
            }

            var value = productOfAll * num

            while (dq.isNotEmpty() && value >= k) {
                answer += dq.size
                value /= dq.removeFirst()
                continue
            }

            productOfAll = value
            dq.addLast(num)
        }

        while (dq.isNotEmpty()) {
            answer += dq.size
            dq.removeFirst()
        }

        return answer
    }
}