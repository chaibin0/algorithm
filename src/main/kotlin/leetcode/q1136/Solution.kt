package leetcode.q1136

import kotlin.math.max

class Solution {

    fun minimumSemesters(n: Int, relations: Array<IntArray>): Int {

        val prevToNextMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        val nextToPrevMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()

        for ((prevCourse, nextCourse) in relations) {
            if (!prevToNextMap.containsKey(prevCourse)) {
                prevToNextMap[prevCourse] = mutableListOf(nextCourse)
                continue
            }
            prevToNextMap[prevCourse]?.add(nextCourse)
        }

        for ((prevCourse, nextCourse) in relations) {
            if (!nextToPrevMap.containsKey(nextCourse)) {
                nextToPrevMap[nextCourse] = mutableListOf(prevCourse)
                continue
            }
            nextToPrevMap[nextCourse]?.add(prevCourse)
        }

        val firstCourseQueue = ArrayDeque<Int>()

        for (i in 1..n) {
            if (nextToPrevMap.containsKey(i)) {
                continue
            }
            firstCourseQueue.add(i)
        }

        val dp = IntArray(n + 1)

        while (firstCourseQueue.isNotEmpty()) {

            val firstCourse = firstCourseQueue.removeFirst()
            val nextCourseQueue = ArrayDeque<Int>()

            nextCourseQueue.add(firstCourse)

            while (nextCourseQueue.isNotEmpty()) {

                val currentCourse = nextCourseQueue.removeFirst()
                dp[currentCourse] = (nextToPrevMap[currentCourse]?.maxOfOrNull { dp[it] } ?: 0) + 1

                if (prevToNextMap[currentCourse] == null) {
                    continue
                }

                next@ for (nextCourse in prevToNextMap[currentCourse]!!) {

                    if (dp[nextCourse] != 0) {
                        return -1
                    }

                    for (prevCourse in nextToPrevMap[nextCourse]!!) {
                        if (dp[prevCourse] == 0) {
                            continue@next
                        }
                    }

                    nextCourseQueue.add(nextCourse)
                }
            }
        }

        var answer = 1

        for (i in 1..n) {
            if (dp[i] == 0) {
                return -1
            }
            answer = max(answer, dp[i])
        }
        return answer
    }

}