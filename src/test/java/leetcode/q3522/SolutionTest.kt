package leetcode.q3522

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val instructions = arrayOf(
            "jump", "add", "add", "jump", "add", "jump"
        )

        val values = intArrayOf(2, 1, 3, 1, -2, -3)

        Solution().calculateScore(instructions, values) shouldBe 1
    }

    test("case2") {
        val instructions = arrayOf(
            "jump", "add", "add", "jump", "jump", "jump"
        )

        val values = intArrayOf(3, 5, 12, -1, -3, -5)

        Solution().calculateScore(instructions, values) shouldBe 1
    }
})
