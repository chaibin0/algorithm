package leetcode.q785

class Solution {

    companion object {
        const val A = 1
        const val B = -1
    }

    fun isBipartite(graph: Array<IntArray>): Boolean {

        for ((index, links) in graph.withIndex()) {
            val bipartite = IntArray(graph.size) { 0 }
            val visit = BooleanArray(graph.size)

            if(visit[index]){
                continue
            }

            visit[index] = true
            bipartite[index] = A

            for (link in links) {
                bipartite[link] = B
            }

            for (link in links) {
                visit[link] = true
                if (!isPossible(link, graph, bipartite, visit, 2)) {
                    return false
                }
            }
        }

        return true
    }

    fun isPossible(
        currentNode: Int,
        graph: Array<IntArray>,
        bipartite: IntArray,
        visit: BooleanArray,
        currentSize: Int,
    ): Boolean {

        val nextSet = if (bipartite[currentNode] == A) B else A

        for (link in graph[currentNode]) {

            if (visit[link]) {
                continue
            }

            if (bipartite[link] != 0 && bipartite[link] != nextSet) {
                return false
            }

            bipartite[link] = nextSet
        }

        for (link in graph[currentNode]) {

            if (visit[link]) {
                continue
            }

            visit[link] = true
            if (!isPossible(link, graph, bipartite, visit, currentSize + 1)) {
                return false
            }
        }

        return true
    }
}