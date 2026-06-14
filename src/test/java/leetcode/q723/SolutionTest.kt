package leetcode.q723

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("candyCrush") {
        val board = arrayOf(
            intArrayOf(110, 5, 112, 113, 114),
            intArrayOf(210, 211, 5, 213, 214),
            intArrayOf(310, 311, 3, 313, 314),
            intArrayOf(410, 411, 412, 5, 414),
            intArrayOf(5, 1, 512, 3, 3),
            intArrayOf(610, 4, 1, 613, 614),
            intArrayOf(710, 1, 2, 713, 714),
            intArrayOf(810, 1, 2, 1, 1),
            intArrayOf(1, 1, 2, 2, 2),
            intArrayOf(4, 1, 4, 4, 1014)
        )

        Solution().candyCrush(board) shouldBe arrayOf(
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(110, 0, 0, 0, 114),
            intArrayOf(210, 0, 0, 0, 214),
            intArrayOf(310, 0, 0, 113, 314),
            intArrayOf(410, 0, 0, 213, 414),
            intArrayOf(610, 211, 112, 313, 614),
            intArrayOf(710, 311, 412, 613, 714),
            intArrayOf(810, 411, 512, 713, 1014),
        )
    }
})
