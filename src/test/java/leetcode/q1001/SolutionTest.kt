package leetcode.q1001

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("gridIllumination") {
        val n = 5
        val lamps = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(4, 4),
        )

        val queries = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 0),
        )

        Solution().gridIllumination(n, lamps, queries) shouldBe intArrayOf(1, 0)
    }
})
