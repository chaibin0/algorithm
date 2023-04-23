package leetcode.q435


class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[1] }

        var count = 0
        var lastEnd = -50001
        for ((start, end) in intervals) {
            if (lastEnd <= start) {
                count++
                lastEnd = end
            }
        }

        return intervals.size - count
    }
}