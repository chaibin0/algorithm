package leetcode.problems.q2300

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val spells = intArrayOf(5, 1, 3)
        val positions = intArrayOf(1, 2, 3, 4, 5)
        val success = 7L
        val answer = intArrayOf(4, 0, 3)
        Solution().successfulPairs(spells, positions, success) shouldBe answer
    }

    test("case2") {
        val spells = intArrayOf(3, 1, 2)
        val positions = intArrayOf(8, 5, 8)
        val success = 16L
        val answer = intArrayOf(2, 0, 2)
        Solution().successfulPairs(spells, positions, success) shouldBe answer
    }

    test("case3") {
        val spells = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val positions = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val success = 25L
        val answer = intArrayOf(0, 0, 0, 1, 3, 3, 4)
        Solution().successfulPairs(spells, positions, success) shouldBe answer
    }

    test("case4") {
        val spells = intArrayOf(15, 8, 19)
        val positions = intArrayOf(38, 36, 23)
        val success = 328L
        val answer = intArrayOf(3, 0, 3)
        Solution().successfulPairs(spells, positions, success) shouldBe answer
    }
})
