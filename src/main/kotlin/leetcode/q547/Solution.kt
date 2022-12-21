package leetcode.q547

class Solution {

    private lateinit var visited: BooleanArray
    var n: Int = 0

    fun findCircleNum(isConnected: Array<IntArray>): Int {
        var answer = 0

        this.n = isConnected.size
        this.visited = BooleanArray(n)

        for ((currentIndex, currentCity) in isConnected.withIndex()) {
            if (visited[currentIndex]) {
                continue
            }

            for ((index, city) in currentCity.withIndex()) {

                if (visited[index]) {
                    continue
                }

                if (city == 0) {
                    continue
                }
                checkVisit(isConnected, index)
                answer++
            }
        }

        return answer
    }

    private fun checkVisit(connected: Array<IntArray>, cityIndex: Int) {

        visited[cityIndex] = true
        for ((index, value) in connected[cityIndex].withIndex()) {
            if (visited[index]) {
                continue
            }

            if (value == 0) {
                continue
            }

            checkVisit(connected, index)
        }
    }
}