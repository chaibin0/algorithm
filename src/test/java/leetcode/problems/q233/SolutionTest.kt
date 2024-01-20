package leetcode.problems.q233

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({
    test("case1") {
        val n = 13
        Solution().countDigitOne(n) shouldBe 6
    }

    test("case2") {
        val n = 20
        Solution().countDigitOne(n) shouldBe 12
    }
})
