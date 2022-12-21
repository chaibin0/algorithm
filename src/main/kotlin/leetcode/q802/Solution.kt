package leetcode.q802

class Solution {

    lateinit var dp: IntArray

    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {

        this.dp = IntArray(graph.size)
        val answers = mutableListOf<Int>()
        for ((currentIndex, currentNodes) in graph.withIndex()) {

            if (currentNodes.isEmpty()) {
                dp[currentIndex] = 1
                answers.add(currentIndex)
                continue
            }

            if (dfs(currentIndex, graph)) {
                answers.add(currentIndex)
            }
        }
        return answers
    }

    fun dfs(currentNode: Int, graph: Array<IntArray>): Boolean {
        if (dp[currentNode] == 1) {
            return true
        }

        if (dp[currentNode] == 2) {
            return false
        }

        dp[currentNode] = 2
        var isSafeNode = true
        for (nextNode in graph[currentNode]) {
            if (!dfs(nextNode, graph)) {
                isSafeNode = false
            }
        }

        dp[currentNode] = if (isSafeNode) 1 else 2
        return isSafeNode
    }
}