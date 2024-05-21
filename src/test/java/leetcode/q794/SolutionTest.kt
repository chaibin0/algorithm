package leetcode.q794

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {

        val board = arrayOf("XOX", "O O", "XOX")
        Solution().validTicTacToe(board) shouldBe true
    }

    test("case2") {

        val board = arrayOf("XXX", "   ", "OOO")
        Solution().validTicTacToe(board) shouldBe true
    }
})
