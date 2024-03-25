package leetcode.problems.q1999

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val k = 2
        val digit1 = 0
        val digit2 = 2
        Solution().findInteger(k, digit1, digit2) shouldBe 20
    }

    test("case2") {
        val k = 3
        val digit1 = 4
        val digit2 = 2
        Solution().findInteger(k, digit1, digit2) shouldBe 24
    }

    test("case3") {
        val k = 2
        val digit1 = 0
        val digit2 = 0
        Solution().findInteger(k, digit1, digit2) shouldBe -1
    }

    test("case4") {
        val k = 3
        val digit1 = 0
        val digit2 = 7
        Solution().findInteger(k, digit1, digit2) shouldBe 777
    }

    test("case5") {
        val k = 5
        val digit1 = 6
        val digit2 = 7
        Solution().findInteger(k, digit1, digit2) shouldBe -1
    }
})
