package leetcode.q3843

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case2") {
        val nums = intArrayOf(20, 20, 10, 30, 30, 30)
        Solution().firstUniqueFreq(nums) shouldBe 20
    }
})
