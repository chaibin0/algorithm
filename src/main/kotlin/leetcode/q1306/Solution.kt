package leetcode.q1306

class Solution {
    fun canReach(arr: IntArray, start: Int): Boolean {

        if (arr[start] == 0) {
            return true
        }

        val visited = BooleanArray(arr.size)

        val dq = ArrayDeque<Int>()
        dq.addLast(start)
        visited[start] = true

        while (dq.isNotEmpty()) {

            val currentPosition = dq.removeFirst()

            val leftPosition = currentPosition - arr[currentPosition]
            val rightPosition = currentPosition + arr[currentPosition]

            if (leftPosition > 0 && !visited[leftPosition]) {
                if (arr[leftPosition] == 0) {
                    return true
                }
                visited[leftPosition] = true
                dq.addLast(leftPosition)
            }

            if (rightPosition < arr.size && !visited[rightPosition]) {
                if (arr[rightPosition] == 0) {
                    return true
                }
                visited[rightPosition] = true
                dq.addLast(rightPosition)
            }
        }

        return false
    }
}