package leetcode.p970

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val x = 73
        val y = 3
        val bound = 700000
        Solution().powerfulIntegers(x, y, bound)
    }

    test("case2") {
        val x = 2
        val y = 1
        val bound = 10
        Solution().powerfulIntegers(x, y, bound)
    }
})
