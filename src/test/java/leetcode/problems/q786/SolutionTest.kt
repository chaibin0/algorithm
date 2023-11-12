package leetcode.problems.q786

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case 1") {
        val arr = intArrayOf(1, 2, 3, 5)
        val k = 3

        Solution().kthSmallestPrimeFraction(arr, k) shouldBe intArrayOf(2, 5)
    }

})
