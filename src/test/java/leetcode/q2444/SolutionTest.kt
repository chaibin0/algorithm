package leetcode.q2444

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("countSubarrays1") {

        val nums = intArrayOf(1, 3, 5, 2, 7, 5)
        val minK = 1
        val maxK = 5
        val output = 2L

        Solution().countSubarrays(nums, minK, maxK) shouldBe output
    }

    test("countSubarrays2") {

        val nums = intArrayOf(1, 1, 1, 1)
        val minK = 1
        val maxK = 1
        val output = 10L

        Solution().countSubarrays(nums, minK, maxK) shouldBe output
    }

    test("countSubarrays3") {

        val nums = intArrayOf(
            35054, 398719, 945315, 945315, 820417, 945315, 35054, 945315, 171832, 945315, 35054, 109750, 790964, 441974,            552913
        )
        val minK = 35054
        val maxK = 945315
        val output = 81L

        Solution().countSubarrays(nums, minK, maxK) shouldBe output
    }
})
