package leetcode.q1129

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("shortestAlternatingPaths") {
        val n = 3
        val redEdges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2)
        )

        val blueEdges = arrayOf<IntArray>()

        Solution().shortestAlternatingPaths(n, redEdges, blueEdges) shouldBe intArrayOf(0, 1, -1)
    }

    test("shortestAlternatingPaths2") {
        val n = 5
        val redEdges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
        )

        val blueEdges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 1)
        )

        Solution().shortestAlternatingPaths(n, redEdges, blueEdges) shouldBe intArrayOf(0, 1, 2, 3, 7)
    }

    test("shortestAlternatingPaths3") {
        val n = 5
        val redEdges = arrayOf(
            intArrayOf(3, 2),
            intArrayOf(4, 1),
            intArrayOf(1, 4),
            intArrayOf(2, 4),
        )

        val blueEdges = arrayOf(
            intArrayOf(2, 3),
            intArrayOf(0, 4),
            intArrayOf(4, 3),
            intArrayOf(4, 4),
            intArrayOf(4, 0),
            intArrayOf(1, 0)
        )

        Solution().shortestAlternatingPaths(n, redEdges, blueEdges) shouldBe intArrayOf(0, 2, -1, -1, 1)
    }

    test("shortestAlternatingPaths4") {
        val n = 5
        val redEdges = arrayOf(
            intArrayOf(2, 2),
            intArrayOf(0, 4),
            intArrayOf(4, 2),
            intArrayOf(4, 3),
            intArrayOf(2, 4),
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(2, 3),
            intArrayOf(1, 3)
        )

        val blueEdges = arrayOf(
            intArrayOf(0, 4),
            intArrayOf(1, 0),
            intArrayOf(1, 4),
            intArrayOf(0, 0),
            intArrayOf(4, 0),
        )

        Solution().shortestAlternatingPaths(n, redEdges, blueEdges) shouldBe intArrayOf(0, 1, 2, 2, 1)
    }
})
