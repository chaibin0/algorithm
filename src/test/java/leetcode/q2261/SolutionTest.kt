package leetcode.q2261

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("countDistinct") {
        val nums = intArrayOf(2, 3, 3, 2, 2)
        val k = 2
        val p = 2

        Solution().countDistinct(nums, k, p) shouldBe 11
    }
})
