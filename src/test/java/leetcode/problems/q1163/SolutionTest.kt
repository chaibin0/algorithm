package leetcode.problems.q1163

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val s = "abab"
        Solution().lastSubstring(s) shouldBe "bab"
    }
})
