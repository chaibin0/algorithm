package leetcode.q2489

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({
    test("case1") {
        val s = "0110011"
        val num1 = 1
        val num2 = 2

        Solution().fixedRatio(s, num1, num2) shouldBe 4
    }

    test("case2") {
        val s = "110010000"
        val num1 = 1
        val num2 = 2

        Solution().fixedRatio(s, num1, num2) shouldBe 1
    }

})
