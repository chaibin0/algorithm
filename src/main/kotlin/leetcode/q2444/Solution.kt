package leetcode.q2444

import java.util.PriorityQueue
import kotlin.math.max


class Solution {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var answer = 0L

        val minIndexPq = PriorityQueue<Int>()
        val maxIndexPq = PriorityQueue<Int>()


        var tail = 0

        for ((index, num) in nums.withIndex()) {

            if (num < minK || num > maxK) {

                while (tail <= index && minIndexPq.isNotEmpty() && maxIndexPq.isNotEmpty()) {

                    val minIndex = minIndexPq.peek()
                    val maxIndex = maxIndexPq.peek()

                    if (minK == maxK) {
                        answer += index - tail
                    } else {
                        answer += (index - max(minIndex, maxIndex))
                    }

                    if (minIndex == tail) {
                        minIndexPq.poll()
                    }

                    if (maxIndex == tail) {
                        maxIndexPq.poll()
                    }

                    tail++
                }

                minIndexPq.clear()
                maxIndexPq.clear()
                tail = index + 1
            }

            if (num == minK) {
                minIndexPq.add(index)
            }

            if (num == maxK) {
                maxIndexPq.add(index)
            }
        }

        println(answer)

        while (tail <= nums.size && minIndexPq.isNotEmpty() && maxIndexPq.isNotEmpty()) {

            val minIndex = minIndexPq.peek()
            val maxIndex = maxIndexPq.peek()

            if (minK == maxK) {
                answer += nums.size - tail
            } else {
                answer += (nums.size - max(minIndex, maxIndex))
            }

            if (minIndex == tail) {
                minIndexPq.poll()
            }

            if (maxIndex == tail) {
                maxIndexPq.poll()
            }

            tail++
        }
        println(answer)
        return answer
    }
}