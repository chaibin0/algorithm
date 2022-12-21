package leetcode.problems.q1376

import kotlin.math.max

class Solution {

    private var answer = 0
    private val map = HashMap<Int, MutableList<Int>>()
    private lateinit var dp: IntArray

    fun numOfMinutes(
        n: Int,
        headID: Int,
        manager: IntArray,
        informTime: IntArray
    ): Int {
        this.dp = IntArray(n)
        dp[headID] = informTime[headID]
        for ((i, value) in manager.withIndex()) {
            if (value == -1) {
                continue
            }
            if (!map.containsKey(value)) {
                map[value] = arrayListOf(i)
                continue
            }

            map[value]!!.add(i)
        }

        dfs(headID, informTime)

        return answer
    }

    private fun dfs(currentID: Int, informTime: IntArray) {
        if (!map.containsKey(currentID)) {
            answer = max(answer, dp[currentID])
            return
        }

        for (employeeId in map[currentID]!!) {
            dp[employeeId] = dp[currentID] + informTime[employeeId]
            dfs(employeeId, informTime)
        }
    }
}