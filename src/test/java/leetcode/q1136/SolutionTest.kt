package leetcode.q1136

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("minimumSemesters") {
        val n = 3
        val relations = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3)
        )

        Solution().minimumSemesters(n, relations) shouldBe 2
    }
})
