package leetcode.q1345

class Solution {
    fun minJumps(arr: IntArray): Int {

        if (arr.size == 1) {
            return 0
        }

        val visited = BooleanArray(arr.size)
        val visitedNum = mutableSetOf<Int>()

        val map = mutableMapOf<Int, MutableList<Int>>()
        for ((index, value) in arr.withIndex()) {
            map.computeIfAbsent(value) { mutableListOf() }
                .add(index)
        }
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(0 to 0)
        visited[0] = true
        while (queue.isNotEmpty()) {
            val (currentIndex, count) = queue.removeFirst()
            if (currentIndex == arr.lastIndex) {
                return count
            }

            if(arr[currentIndex] == arr.last()) {
                return count + 1
            }

            if (currentIndex - 1 >= 0 && !visited[currentIndex - 1]) {
                queue.add((currentIndex - 1) to (count + 1))
                visited[currentIndex - 1] = true
            }

            if (currentIndex + 1 < arr.size && !visited[currentIndex + 1]) {
                if(currentIndex + 1 == arr.lastIndex) {
                    return count + 1
                }
                queue.add((currentIndex + 1) to (count + 1))
                visited[currentIndex + 1] = true
            }

            if(visitedNum.contains(arr[currentIndex])) {
                continue
            }

            for (jumpIndex in map[arr[currentIndex]]!!) {
                if (visited[jumpIndex] || jumpIndex == currentIndex) {
                    continue
                }

                if(jumpIndex == arr.lastIndex) {
                    return count + 1
                }

                queue.add(jumpIndex to (count + 1))
                visited[jumpIndex] = true
            }

            visitedNum.add(arr[currentIndex])
        }

        return 0
    }
}