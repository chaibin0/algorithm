package leetcode.problems.q1319

class Solution {

    private lateinit var visited: BooleanArray
    private lateinit var graph: Array<BooleanArray>
    private var n: Int = 0
    private var activeConnectionSize = 0
    private var activeGroupSize = 0

    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        this.visited = BooleanArray(n)
        this.graph = Array(n) {
            BooleanArray(n)
        }
        this.n = n

        val connectionCount = connections.size
        this.activeGroupSize = 0
        this.activeConnectionSize = 0

        for (connection in connections) {
            this.graph[connection[0]][connection[1]] = true
            this.graph[connection[1]][connection[0]] = true
        }


        for (y in 0 until n) {
            if (this.visited[y]) {
                continue
            }

            var isGrouped = false

            for (x in 0 until n) {
                if (!graph[y][x]) {
                    continue
                }

                if (!this.visited[x]) {
                    dfs(x)
                    isGrouped = true
                    activeGroupSize++
                }

                if (!this.visited[y]) {
                    dfs(y)
                    isGrouped = true
                    activeGroupSize++
                }
            }

            if (!isGrouped) {
                activeGroupSize++
            }
        }

        val remainNode = connectionCount - (activeConnectionSize - 1)
        val needNode = activeGroupSize - 1
        return if (needNode <= remainNode) needNode else -1
    }

    private fun dfs(node: Int) {
        this.visited[node] = true
        activeConnectionSize++
        for (i in 0 until n) {
            if (!graph[node][i]) {
                continue
            }

            if (!this.visited[i]) {
                dfs(i)
            }
        }
    }
}