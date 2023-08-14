package leetcode.problems.q639

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val s = "2*"
        Solution().numDecodings(s) shouldBe 15
    }

    test("case2") {
        val s = "***"
        Solution().numDecodings(s) shouldBe 999
    }

    test("case3") {
        val s = "*1*1*0"
        Solution().numDecodings(s) shouldBe 404
    }

    test("case4") {
        val s = "104"
        Solution().numDecodings(s) shouldBe 1
    }

    test("case5") {
        val s = "904"
        Solution().numDecodings(s) shouldBe 1
    }

    test("case6") {
        val s = "2839"
        Solution().numDecodings(s) shouldBe 1
    }

    test("case7") {
        val s = "7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*"
        Solution().numDecodings(s) shouldBe 196465252
    }

})
