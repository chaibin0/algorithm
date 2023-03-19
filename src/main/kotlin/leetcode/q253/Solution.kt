package leetcode.q253

class Solution {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        var answer = 0
        intervals.sortWith(Comparator<IntArray>{ a, b ->
            when {
                a[0] == b[0] -> a[1] - a[2]
                else -> a[0] - b[0]
            }
        })

        var currentStart = -1
        var currentEnd = -1

        for ((start, end) in intervals) {
            if (currentStart <= start && end <= currentEnd) {
                continue
            }

            currentStart = start
            currentEnd = end
            answer++
        }

        return answer
    }
}