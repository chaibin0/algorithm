package leetcode.q291

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("wordPatternMatch") {
        val pattern = "abab"
        val s = "redblueredblue"
        Solution().wordPatternMatch(pattern, s) shouldBe true
    }

    test("wordPatternMatch2") {
        val pattern = "abab"
        val s = "asdasdasdasd"
        Solution().wordPatternMatch(pattern, s) shouldBe true
    }
})
