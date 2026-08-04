package leetcode.q2107

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("shareCandies") {
        val candies = intArrayOf(1, 2, 2, 3, 4, 3)
        val k = 3
        Solution().shareCandies(candies, k) shouldBe 3
    }
})
