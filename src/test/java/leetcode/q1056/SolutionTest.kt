package leetcode.q1056

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({
    test("case1") {
        val n = 6
        Solution().confusingNumber(n) shouldBe true
    }

    test("case2") {
        val n = 89
        Solution().confusingNumber(n) shouldBe true
    }
})
