package leetcode.problems.q1318

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({
    test("case1") {
        val a = 2
        val b = 6
        val c = 5

        Solution().minFlips(a, b, c) shouldBe 3
    }
})
