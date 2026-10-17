package leetcode.q3007

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("findMaximumNumber") {
        val k = 9L
        val x = 1
        Solution().findMaximumNumber(k, x) shouldBe 6
    }

    test("findMaximumNumber2") {
        val k = 7L
        val x = 2
        Solution().findMaximumNumber(k, x) shouldBe 9
    }
})
