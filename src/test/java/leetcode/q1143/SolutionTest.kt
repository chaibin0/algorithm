package leetcode.q1143

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("longestCommonSubsequence") {
        val text1 = "abcde"
        val text2 = "ace"
        Solution().longestCommonSubsequence(text1, text2) shouldBe 3
    }

    test("longestCommonSubsequence2") {

        val text1 = "psnw"
        val text2 = "vozsh"
        Solution().longestCommonSubsequence(text1, text2) shouldBe 1
    }
})
