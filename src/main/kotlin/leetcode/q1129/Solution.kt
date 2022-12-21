package leetcode.q1129

import kotlin.math.min


class Solution {

    fun shortestAlternatingPaths(
        n: Int,
        redEdges: Array<IntArray>,
        blueEdges: Array<IntArray>
    ): IntArray {

        val map = Array<MutableList<Pair<Int, Int>>>(n) { arrayListOf() }
        val visited: Array<IntArray> = Array(2) { IntArray(n) { -1 } }
        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()
        val result = IntArray(n) { -1 }.also {
            it[0] = 0
        }

        for (redEdge in redEdges) {
            map[redEdge[0]].add(redEdge[1] to RED)
        }
        for (blueEdge in blueEdges) {
            map[blueEdge[0]].add(blueEdge[1] to BLUE)
        }
        visited[RED][0] = 0
        visited[BLUE][0] = 0

        queue.add(0 to RED)
        queue.add(0 to BLUE)

        while (queue.isNotEmpty()) {

            val (currentNode, currentColor) = queue.removeFirst()
            for ((nextNode, nextColor) in map[currentNode]) {
                if (currentColor == nextColor) {
                    continue
                }
                if (visited[nextColor][nextNode] != -1) {
                    continue
                }
                visited[nextColor][nextNode] = visited[currentColor][currentNode] + 1
                queue.add(nextNode to nextColor)
            }
        }


        for (i in 1 until n) {
            if (visited[BLUE][i] == -1) {
                result[i] = visited[RED][i]
            } else if (visited[RED][i] == -1) {
                result[i] = visited[BLUE][i]
            } else {
                result[i] = min(visited[RED][i], visited[BLUE][i])
            }
        }

        return result
    }

    companion object {
        private const val BLUE = 1
        private const val RED = 0
    }
}