package leetcode.q539

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("findMinDifference") {
        val timePoints = listOf("23:59", "00:00")

        Solution().findMinDifference(timePoints) shouldBe 1
    }
})
