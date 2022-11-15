package leetcode.q322

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("coinChange1") {
        val coins = intArrayOf(1, 2, 5)
        val amount = 11
        Solution().coinChange(coins, amount) shouldBe 3
    }

    test("coinChange2") {
        val coins = intArrayOf(2)
        val amount = 3
        Solution().coinChange(coins, amount) shouldBe -1
    }
})
