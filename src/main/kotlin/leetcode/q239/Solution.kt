package leetcode.q239

import java.util.PriorityQueue

class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {

        val answer = mutableListOf<Int>()

        val numsNode: Array<Node?> = Array(nums.size) { null }
        val pq: PriorityQueue<Node> = PriorityQueue(Comparator<Node> { n1, n2 -> n2.num.compareTo(n1.num) })

        var count = 0
        for (i in 0 until k) {
            val node = Node(nums[i])
            numsNode[i] = node
            pq.add(node)
        }

        answer.add(pq.peek().num)

        for ((index, num) in nums.withIndex()) {
            if (index < k) {
                continue
            }

            val node = Node(num)
            pq.add(node)
            numsNode[index] = node

            numsNode[index - k]!!.unused = true

            while (pq.isNotEmpty()) {
                if (!(pq.peek().unused)) {
                    break
                }

                pq.remove()
            }

            answer.add(pq.peek().num)
        }

        return answer.toIntArray()
    }
}

class Node(val num: Int) {
    var unused = false
}