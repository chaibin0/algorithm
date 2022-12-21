package leetcode.problems.q1376

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

//6
//2
//[2,2,-1,2,2,3]
//[0,0,1,5,0,0]
class SolutionTest : FunSpec({

    test("numOfMinutes") {
        val n = 6
        val headId = 2
        val manager = intArrayOf(2, 2, -1, 2, 2, 3)
        val informTime = intArrayOf(0, 0, 1, 5, 0, 0)
        Solution().numOfMinutes(n,headId, manager, informTime) shouldBe 6
    }
})
