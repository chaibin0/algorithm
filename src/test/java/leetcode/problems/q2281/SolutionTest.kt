package leetcode.problems.q2281

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import leetcode.answers.q2281.Solution
import leetcode.q2281.SolutionFail2

class SolutionTest : FunSpec({

    test("totalStrength1") {

        val strength = intArrayOf(1, 3, 1, 2)
        val result = 44

        Solution().totalStrength(strength) shouldBe result
    }
})
