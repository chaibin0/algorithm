package leetcode.q315

import java.util.*


//class Solution {
//    fun countSmaller(nums: IntArray): List<Int> {
//        val queue = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.first - o2.first }
//        val answer = MutableList(nums.size) { 0 }
//        for (i in nums.lastIndex.downTo(0)) {
//            var isSelf = false
//            var sum = 0
//            for(j in queue.indices) {
//                if (queue.peek().first > nums[i]) {
//                    break
//                }
//
//                val (number, count) = queue.poll()
//
//                if (number == nums[i]) {
//                    queue.add(number to (count + 1))
//                    isSelf = true
//                    continue
//                }
//                queue.add(number to (count)
//                sum += count
//            }
//
//            answer[i] = sum
//            if (!isSelf) {
//                queue.add(nums[i] to 1)
//            }
//        }
//
//        return answer
//    }
//}