package leetcode.q311

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val mat1 = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(-1, 0, 3)
        )

        val mat2 = arrayOf(
            intArrayOf(7, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 1)
        )

        Solution().multiply(mat1, mat2)
    }
})
