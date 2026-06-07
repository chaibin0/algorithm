package leetcode.q2428

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val grid = arrayOf(
            intArrayOf(6, 2, 1, 3),
            intArrayOf(4, 2, 1, 5),
            intArrayOf(9, 2, 8, 7),
            intArrayOf(4, 1, 2, 9)
        )
        val solution = Solution()
        val result = solution.maxSum(grid)
        result shouldBe 30
    }
})
