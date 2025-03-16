package leetcode.q2044

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val nums = intArrayOf(3, 1)
        Solution().countMaxOrSubsets(nums) shouldBe 2
    }
})
