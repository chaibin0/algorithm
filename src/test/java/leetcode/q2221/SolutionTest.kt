package leetcode.q2221

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("triangularSum") {
        val nums = intArrayOf(1, 2, 3, 4, 5)

        Solution().triangularSum(nums) shouldBe 8
    }
})
