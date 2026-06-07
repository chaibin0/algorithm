package leetcode.q1064

class Solution {
    fun fixedPoint(arr: IntArray): Int {
        var low = 0
        var high = arr.size - 1
        var answer = Int.MAX_VALUE
        while (low <= high) {
            val mid = (high + low) / 2
            if (arr[mid] == mid) {
                answer = minOf(answer, mid)
            }
            if (arr[mid] < mid) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }

        return if (answer == Int.MAX_VALUE) -1 else answer
    }
}