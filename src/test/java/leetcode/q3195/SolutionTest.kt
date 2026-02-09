package leetcode.q3195

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("countCompleteDayPairs") {
        val hours = intArrayOf(12, 12, 30, 24, 24)
        Solution().countCompleteDayPairs(hours) shouldBe 2
    }
})
