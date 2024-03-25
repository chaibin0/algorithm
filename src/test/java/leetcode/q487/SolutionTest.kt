package leetcode.q487

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val nums = intArrayOf(0, 0)
        Solution().findMaxConsecutiveOnes(nums) shouldBe 1
    }
})
