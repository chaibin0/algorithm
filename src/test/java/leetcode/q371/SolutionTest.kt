package leetcode.q371

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val a = 1
        val b = 2
        Solution().getSum(a, b) shouldBe 3
    }

    test("case2") {
        val a = -100
        val b = 50
        Solution().getSum(a, b) shouldBe -50
    }

    test("case3") {
        val a = 2
        val b = 3
        Solution().getSum(a, b) shouldBe 5
    }

    test("case4") {
        val a = 5
        val b = -8
        Solution().getSum(a, b) shouldBe -3
    }
})
