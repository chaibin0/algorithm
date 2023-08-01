package leetcode.problems.q2542

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val nums1 = intArrayOf(1, 3, 3, 2)
        val nums2 = intArrayOf(2, 1, 3, 4)
        val k = 3;

        Solution().maxScore(nums1, nums2, k) shouldBe 12
    }

    test("case2") {
        val nums1 = intArrayOf(2, 1, 14, 12)
        val nums2 = intArrayOf(11, 7, 13, 6)
        val k = 3;

        Solution().maxScore(nums1, nums2, k) shouldBe 168
    }
})
