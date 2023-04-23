package leetcode.q435

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("eraseOverlapIntervals") {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(-100, -2),
            intArrayOf(5, 7)
        )

        Solution().eraseOverlapIntervals(intervals) shouldBe 0

    }

    test("eraseOverlapIntervals2") {
        val intervals = arrayOf(
            intArrayOf(-52, 31),
            intArrayOf(-73, -26),
            intArrayOf(82, 97),
            intArrayOf(-65, -11),
            intArrayOf(-62, -49),
            intArrayOf(95, 99),
            intArrayOf(58, 95),
            intArrayOf(-31, 49),
            intArrayOf(66, 98),
            intArrayOf(-63, 2),
            intArrayOf(30, 47),
            intArrayOf(-40, -26)
        )

        Solution().eraseOverlapIntervals(intervals) shouldBe 7

    }
})
