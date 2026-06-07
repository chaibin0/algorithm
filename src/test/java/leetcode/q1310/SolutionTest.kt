package leetcode.q1310

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("xorQueries1") {
        val arr = intArrayOf(1, 3, 4, 8)
        val queries = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(0, 3),
            intArrayOf(3, 3),
        )

        Solution().xorQueries(arr, queries) shouldBe intArrayOf(2, 7, 14, 8)
    }

    test("xorQueries2") {
        val arr = intArrayOf(4, 8, 2, 10)
        val queries = arrayOf(
            intArrayOf(2, 3),
            intArrayOf(1, 3),
            intArrayOf(0, 0),
            intArrayOf(0, 3),
        )

        Solution().xorQueries(arr, queries) shouldBe intArrayOf(8, 0, 4, 4)
    }
})
