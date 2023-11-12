package leetcode.problems.q2306

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import leetcode.answers.q2306.Solution
class SolutionTest : FunSpec({


    test("case1") {
        val ideas = arrayOf("aaa", "baa", "caa", "bbb", "cbb", "dbb");
        Solution().distinctNames(ideas) shouldBe 2
    }
})