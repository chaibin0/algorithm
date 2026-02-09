package leetcode.q562

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {

        val mat = arrayOf(
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 0, 0, 1)
        )

        Solution().longestLine(mat) shouldBe 3
    }

    test("case2") {

        val mat = arrayOf(
            intArrayOf(0),
            intArrayOf(1),
        )

        Solution().longestLine(mat) shouldBe 3
    }
})
