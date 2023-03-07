package leetcode.q2386

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("kSum") {

        val nums = intArrayOf(2, 4, -2)
        Solution().kSum(nums, 5) shouldBe 2
    }

    test("kSum2") {

        val nums = intArrayOf(1,-2,3,4,-10,12)
        Solution().kSum(nums, 16) shouldBe 10
    }
})
