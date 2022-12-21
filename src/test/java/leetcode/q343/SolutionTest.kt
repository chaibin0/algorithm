package leetcode.q343

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("integerBreak") {
        val n = 10
        Solution().integerBreak(n) shouldBe 36
    }

    test("integerBreak2") {
        val n = 4
        Solution().integerBreak(n) shouldBe 4
    }

    test("integerBreak3") {
        val n = 2
        Solution().integerBreak(n) shouldBe 1
    }

    test("integerBreak4") {
        val n = 3
        Solution().integerBreak(n) shouldBe 2
    }
})
