package leetcode.q1864

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("minSwaps") {
        val s = "111000"
        val expected = 1
        Solution().minSwaps(s) shouldBe expected
    }

    test("minSwaps2") {
        val s = "1110"
        val expected = -1
        Solution().minSwaps(s) shouldBe expected
    }
})
