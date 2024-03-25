package leetcode.q1631

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val heights = arrayOf(
            intArrayOf(1, 2, 2),
            intArrayOf(3, 8, 2),
            intArrayOf(5, 3, 5)
        )

        Solution().minimumEffortPath(heights) shouldBe 2
    }
})
