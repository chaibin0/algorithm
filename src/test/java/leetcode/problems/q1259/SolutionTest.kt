package leetcode.problems.q1259

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val numPeople = 4

        Solution().numberOfWays(numPeople) shouldBe 2
    }

    test("case2") {
        val numPeople = 6

        Solution().numberOfWays(numPeople) shouldBe 5
    }


})
