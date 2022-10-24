package leetcode.q392

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("isSubsequence1") {
        val s = "axc"
        val t = "ahbgdc"
        Solution().isSubsequence(s, t) shouldBe false
    }

    test("isSubsequence2") {
        val s = ""
        val t = "ahbgdc"
        Solution().isSubsequence(s, t) shouldBe false
    }

    test("isSubsequence3") {
        val s = "b"
        val t = "c"
        Solution().isSubsequence(s, t) shouldBe false
    }
})
