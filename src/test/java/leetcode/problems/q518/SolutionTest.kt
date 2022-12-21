package leetcode.problems.q518

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("test1") {
        val amount = 5
        val coins = intArrayOf(1, 2, 5)
        Solution().change(amount, coins) shouldBe 4
    }
})
