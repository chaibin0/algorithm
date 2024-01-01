package leetcode.problems.q1792

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({
    test("case1") {
        val classes = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 5),
            intArrayOf(2, 2)
        )

        val extraStudents = 2

        Solution().maxAverageRatio(classes, extraStudents) shouldBe 0.78333

    }
})
