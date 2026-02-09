package leetcode.q1043

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("maxSumAfterPartitioning") {
        val arr = intArrayOf(1, 15, 7, 9, 2, 5, 10)
        val k = 3
        Solution().maxSumAfterPartitioning(arr, 3) shouldBe 84
    }
})
