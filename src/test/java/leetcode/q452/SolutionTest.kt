package leetcode.q452

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("findMinArrowShots") {
        val points = arrayOf(
            intArrayOf(10, 16),
            intArrayOf(2, 8),
            intArrayOf(1, 6),
            intArrayOf(7, 12)
        )

        Solution().findMinArrowShots(points) shouldBe 2
    }

    test("findMinArrowShots2") {
        val points = arrayOf(
            intArrayOf(-2147483646, -2147483645),
            intArrayOf(2147483646, 2147483647),
        )

        Solution().findMinArrowShots(points) shouldBe 2
    }
})
