package leetcode.q1081

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val solution = Solution()
        val result = solution.smallestSubsequence("bcabc")
        result shouldBe "abc"
    }

    test("case2"){
        val solution = Solution()
        val result = solution.smallestSubsequence("cbacdcbc")
        result shouldBe "acdb"
    }
})
