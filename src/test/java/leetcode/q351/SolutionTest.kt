package leetcode.q351

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("numberOfPatterns") {

        val m = 1
        val n = 2
        Solution().numberOfPatterns(m, n) shouldBe 65
    }
})
