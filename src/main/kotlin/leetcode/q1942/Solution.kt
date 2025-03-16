package leetcode.q1942

import java.util.PriorityQueue

class Solution {

    private val remain = PriorityQueue<Int>()
    private val occupiedChairs = mutableMapOf<Int, Int>()
    private var currentChair = 1

    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {

        val arrivals = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
            p1.first.compareTo(p2.first)
        }
        val leavings = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
            p1.first.compareTo(p2.first)
        }

        for ((index, time) in times.withIndex()) {
            val (arrival, leaving) = time
            arrivals.add(arrival to index)
            leavings.add(leaving to index)
        }

        remain.add(0)

        while (leavings.isNotEmpty() && arrivals.isNotEmpty()) {
            val (latestArrival, arrivalIndex) = arrivals.peek()
            val (latestLeaving, leavingIndex) = leavings.peek()

            if (latestArrival < latestLeaving) {
                arrivals.remove()
                if (arrivalIndex == targetFriend) {
                    return if (remain.isEmpty()) {
                        currentChair
                    } else {
                        remain.peek()
                    }
                }

                if (remain.isEmpty()) {
                    remain.add(currentChair++)
                }

                val remainChair = remain.poll()
                occupiedChairs[arrivalIndex] = remainChair
            } else {
                leavings.remove()
                remain.add(occupiedChairs[leavingIndex])
            }
        }
        while (leavings.isNotEmpty()) {
            val (latestLeaving, leavingIndex) = leavings.poll()
            remain.add(occupiedChairs[leavingIndex])
        }

        while (arrivals.isNotEmpty()) {
            val (latestArrival, arrivalIndex) = arrivals.poll()
            if (arrivalIndex == targetFriend) {
                return if (remain.isEmpty()) {
                    currentChair
                } else {
                    remain.peek()
                }
            }

            if (remain.isEmpty()) {
                remain.add(++currentChair)
            }

            val remainChair = remain.poll()
            occupiedChairs[arrivalIndex] = remainChair
        }

        return -1
    }
}