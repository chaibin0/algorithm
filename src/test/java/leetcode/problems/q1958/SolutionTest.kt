package leetcode.problems.q1958

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val board = arrayOf(
            charArrayOf('.', '.', '.', 'B', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'W', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'W', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'W', '.', '.', '.', '.'),
            charArrayOf('W', 'B', 'B', '.', 'W', 'W', 'W', 'B'),
            charArrayOf('.', '.', '.', 'B', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'B', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'W', '.', '.', '.', '.')
        )
        val rMove = 4
        val cMove = 3
        val color = 'B'

        Solution().checkMove(board, rMove, cMove, color) shouldBe true
    }
    test("case2") {
        val board = arrayOf(
            charArrayOf('W', 'W', '.', 'B', '.', 'B', 'B', '.'),
            charArrayOf('W', 'B', '.', '.', 'W', 'B', '.', '.'),
            charArrayOf('B', 'B', 'B', 'B', 'W', 'W', 'B', '.'),
            charArrayOf('W', 'B', '.', '.', 'B', 'B', 'B', '.'),
            charArrayOf('W', 'W', 'B', '.', 'W', '.', 'B', 'B'),
            charArrayOf('B', '.', 'B', 'W', '.', 'B', '.', '.'),
            charArrayOf('.', 'B', 'B', 'W', 'B', 'B', '.', '.'),
            charArrayOf('B', 'B', 'W', '.', '.', 'B', '.', '.')
        )
        val rMove = 7
        val cMove = 4
        val color = 'B'

        Solution().checkMove(board, rMove, cMove, color) shouldBe true
    }
})
