package leetcode.q1035

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val nums1 = intArrayOf(4, 1, 2, 5, 1, 5, 3, 4, 1, 5)
        val nums2 = intArrayOf(3, 1, 1, 3, 2, 5, 2, 4, 1, 3, 2, 2, 5, 5, 3, 5, 5, 1, 2, 1)
        Solution().maxUncrossedLines(nums1, nums2) shouldBe 7
    }
})
