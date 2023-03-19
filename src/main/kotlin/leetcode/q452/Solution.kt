package leetcode.q452

class Solution {

    fun findMinArrowShots(points: Array<IntArray>): Int {

        var answer = 1
        points.sortWith(Comparator<IntArray> { o1, o2 ->
            when {
                o1[1] == o2[1] -> o1[0].compareTo(o2[0])
                else -> o1[1].compareTo(o2[1])
            }
        })

        var (currentStartX, currentEndX) = points[0]

        for ((i, point) in points.withIndex()) {
            val (startX, endX) = point
            if (startX <= currentEndX) {
                continue
            }
            answer++
            currentStartX = startX
            currentEndX = endX
        }

        return answer
    }
}