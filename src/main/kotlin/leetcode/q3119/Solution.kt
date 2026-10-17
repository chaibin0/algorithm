package leetcode.q3119

import java.util.PriorityQueue

class Solution {
    fun maxPotholes(road: String, budget: Int): Int {

        val pq = PriorityQueue<Int>(Comparator.reverseOrder())
        var answer = 0
        var count = 0
        var currentBudget = budget
        for (current in road) {
            if (current == '.') {
                if (count != 0) {
                    pq.add(count)
                }

                count = 0
                continue
            }
            count++
        }

        if (count != 0) {
            pq.add(count)
        }

        while (!pq.isEmpty() && currentBudget > 1) {
            val current = pq.poll()
            if (current + 1 > currentBudget) {
                answer += currentBudget - 1
                break
            }
            currentBudget -= current + 1
            answer += current
        }

        return answer
    }
}