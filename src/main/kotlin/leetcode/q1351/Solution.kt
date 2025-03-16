package leetcode.q1351

class Solution {
    fun countNegatives(grid: Array<IntArray>): Int {
        var answer = 0
        val m = grid.size
        val n = grid[0].size

        for (array in grid) {

            var low = 0
            var high = n - 1
            while (low <= high) {
                val mid = (low + high) / 2
                val value = array[mid]
                if (value >= 0) {
                    low = mid + 1
                } else {
                    high = mid - 1
                }
            }
            answer += (n - low)
        }

        return answer
    }
}