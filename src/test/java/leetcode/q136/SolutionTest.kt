package leetcode.q136

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val nums = intArrayOf(2, 2, 1)

        Solution().singleNumber(nums) shouldBe 1
    }
})
