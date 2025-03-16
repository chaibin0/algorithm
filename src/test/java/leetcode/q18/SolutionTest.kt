package leetcode.q18

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {

        val nums = intArrayOf(1, 0, -1, 0, -2, 2)
        val target = 0

        Solution().fourSum(nums, target) shouldBe 0
    }

    test("case2") {

        val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
        val target = -1

        Solution().fourSum(nums, target) shouldBe 0
    }


})
