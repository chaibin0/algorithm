package leetcode.q503

class Solution {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val answer = IntArray(nums.size) { Int.MIN_VALUE }
        val deque = ArrayDeque<Int>()
        traverse(nums, deque, answer)
        traverse(nums, deque, answer)
        return answer
    }

    private fun traverse(nums: IntArray, deque: ArrayDeque<Int>, answer: IntArray) {

        for (index in nums.indices.reversed()) {

            if (deque.isEmpty()) {
                deque.addLast(nums[index])
                continue
            }

            while (deque.isNotEmpty() && nums[index] >= deque.last()) {
                deque.removeLast()
            }

            if (deque.isEmpty()) {
                answer[index] = -1
                deque.addLast(nums[index])
                continue
            }

            answer[index] = deque.last()
            deque.addLast(nums[index])
        }
    }
}