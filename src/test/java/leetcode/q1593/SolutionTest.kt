package leetcode.q1593

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("maxUniqueSplit") {
        val s = "ababccc"
        Solution().maxUniqueSplit(s) shouldBe 5
    }
})
