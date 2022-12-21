package leetcode.q1129

import kotlin.math.max
import kotlin.math.min


class Solution2 {

    fun shortestAlternatingPaths(
        n: Int,
        redEdges: Array<IntArray>,
        blueEdges: Array<IntArray>
    ): IntArray {

        val redEdgeMap: MutableMap<Int, MutableList<Int>> = HashMap()
        val blueEdgeMap: MutableMap<Int, MutableList<Int>> = HashMap()

        for (red in redEdges) {
            val (from, end) = red
            if (!redEdgeMap.containsKey(from)) {
                redEdgeMap[from] = mutableListOf(end)
                continue
            }

            redEdgeMap[from]!!.add(end)
        }

        for (blue in blueEdges) {
            val (from, end) = blue
            if (!blueEdgeMap.containsKey(from)) {
                blueEdgeMap[from] = mutableListOf(end)
                continue
            }

            blueEdgeMap[from]!!.add(end)
        }


        val firstResult = solve(n, redEdgeMap, blueEdgeMap, true)
        val secondResult = solve(n, redEdgeMap, blueEdgeMap, false)
        for (i in firstResult.indices) {

            if (firstResult[i] == -1 || secondResult[i] == -1) {
                firstResult[i] = max(firstResult[i], secondResult[i])
                continue
            }

            firstResult[i] = min(firstResult[i], secondResult[i])
        }

        firstResult[0] = 0
        return firstResult
    }

    fun solve(
        n: Int,
        redEdges: MutableMap<Int, MutableList<Int>>,
        blueEdges: MutableMap<Int, MutableList<Int>>,
        isBlueStart: Boolean
    ): IntArray {

        val redVisited = BooleanArray(n)
        val blueVisited = BooleanArray(n)

        val result = IntArray(n) { -1 }
        val dp = IntArray(n) { 0 }

        val queue: ArrayDeque<Pair<Int, Boolean>> = ArrayDeque()

        var edgesPointer: MutableMap<Int, MutableList<Int>> = if (isBlueStart == IS_BLUE) blueEdges else redEdges
        var visitedPointer: BooleanArray = if (isBlueStart == IS_BLUE) blueVisited else redVisited

        if (!edgesPointer.containsKey(0)) {
            return result
        }

        for (i in edgesPointer[0]!!) {
            queue.addLast(i to !isBlueStart)
            visitedPointer[i] = true
            dp[i] = 1
            result[i] = 1
        }

        while (queue.isNotEmpty()) {
            val (currentNode, isBlue) = queue.removeFirst()
            edgesPointer = if (isBlue == IS_BLUE) blueEdges else redEdges
            visitedPointer = if (isBlue == IS_BLUE) blueVisited else redVisited

            if (!edgesPointer.containsKey(currentNode)) {
                continue
            }

            for (i in edgesPointer[currentNode]!!) {
                if (visitedPointer[i]) {
                    result[i] = min(result[i], dp[currentNode] + 1)
                    dp[i] = min(dp[i], dp[currentNode] + 1)
                    continue
                }

                result[i] = if (result[i] == -1) dp[currentNode] + 1 else min(result[i], dp[currentNode] + 1)
                dp[i] = dp[currentNode] + 1
                visitedPointer[i] = true
                queue.addLast(i to !isBlue)
            }
        }

        return result
    }

    companion object {
        private const val IS_BLUE = true
    }
}