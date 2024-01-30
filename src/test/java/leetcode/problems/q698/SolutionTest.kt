package leetcode.problems.q698

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val nums = intArrayOf(4, 3, 2, 3, 5, 2, 1)
        val k = 4

        Solution().canPartitionKSubsets(nums, k) shouldBe true
    }
})
