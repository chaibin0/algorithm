package leetcode.problems.q1536

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val grid = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 0)
        )

        Solution().minSwaps(grid) shouldBe 3
    }

    test("case2") {
        val grid = arrayOf(
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 1, 1, 0)
        )

        Solution().minSwaps(grid) shouldBe -1
    }

    test("case3") {
        val grid = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 1)
        )

        Solution().minSwaps(grid) shouldBe 0
    }

    test("case4") {
        val grid = arrayOf(
            intArrayOf(1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 1, 0, 0),
            intArrayOf(0, 0, 0, 1, 0, 0),
            intArrayOf(0, 1, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 1)
        )

        Solution().minSwaps(grid) shouldBe 4

    }

    test("case5") {
        val grid = arrayOf(
            intArrayOf(1, 0, 0, 0, 0, 0),
            intArrayOf(0, 1, 0, 1, 0, 0),
            intArrayOf(1, 0, 0, 0, 0, 0),
            intArrayOf(1, 1, 1, 0, 0, 0),
            intArrayOf(1, 1, 0, 1, 0, 0),
            intArrayOf(1, 0, 0, 0, 0, 0)
        )

        Solution().minSwaps(grid) shouldBe 2

    }


})
