package leetcode.q1926

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("nearestExit") {
        val maze = arrayOf(
            charArrayOf('+', '+', '.', '+'),
            charArrayOf('.', '.', '.', '+'),
            charArrayOf('+', '+', '+', '.')
        )

        val entrance = intArrayOf(1, 2)

        Solution().nearestExit(maze, entrance) shouldBe 1
    }

    test("nearestExit2") {
        val maze = arrayOf(
            charArrayOf('.', '+'),
        )

        val entrance = intArrayOf(0, 0)

        Solution().nearestExit(maze, entrance) shouldBe -1
    }

    test("nearestExit3") {
        val maze = arrayOf(
            charArrayOf('+', '.', '+', '+', '+', '+', '+'),
            charArrayOf('+', '.', '+', '.', '.', '.', '+'),
            charArrayOf('+', '.', '+', '.', '+', '.', '+'),
            charArrayOf('+', '.', '.', '.', '+', '.', '+'),
            charArrayOf('+', '+', '+', '+', '+', '.', '+')

        )

        val entrance = intArrayOf(0, 1)

        Solution().nearestExit(maze, entrance) shouldBe 12
    }

})
