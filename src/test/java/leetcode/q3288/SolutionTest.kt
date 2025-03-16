package leetcode.q3288

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val coordinates = arrayOf(
            intArrayOf(3, 1),
            intArrayOf(2, 2),
            intArrayOf(4, 1),
            intArrayOf(0, 0),
            intArrayOf(5, 3)
        )
        val k = 1

        Solution().maxPathLength(coordinates, k) shouldBe 3
    }

    test("case2") {
        val coordinates = arrayOf(
            intArrayOf(7, 6),
            intArrayOf(5, 8),
            intArrayOf(4, 6),
            intArrayOf(4, 3),
            intArrayOf(6, 4)
        )
        val k = 3

        Solution().maxPathLength(coordinates, k) shouldBe 3
    }
})
