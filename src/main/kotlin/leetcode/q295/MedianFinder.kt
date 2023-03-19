package leetcode.q295

import java.util.PriorityQueue


class MedianFinder() {

    private val frontPq = PriorityQueue(Comparator<Int> { o1, o2 -> o2 - o1 })
    private val backPq = PriorityQueue(Comparator<Int> { o1, o2 -> o1 - o2 })

    private var size = 0

    fun addNum(num: Int) {

        if (backPq.isNotEmpty() && backPq.peek() <= num) {
            backPq.add(num)
        } else {
            frontPq.add(num)
        }

        when {
            backPq.size == frontPq.size - 2 -> backPq.add(frontPq.poll())
            frontPq.size == backPq.size - 2 -> frontPq.add(backPq.poll())
        }

        size++
    }

    fun findMedian(): Double {

        if (size % 2 == 1) {
            return when {
                backPq.size > frontPq.size -> backPq.peek().toDouble()
                else -> frontPq.peek().toDouble()
            }
        }

        return (backPq.peek() + frontPq.peek()).toDouble() / 2
    }
}