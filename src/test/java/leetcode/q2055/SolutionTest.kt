package leetcode.q2055

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("platesBetweenCandles") {

        val s = "**|**|***|"
        val queries = arrayOf(
            intArrayOf(2, 5),
            intArrayOf(5, 9)
        )

        Solution().platesBetweenCandles(s, queries) shouldBe intArrayOf(2, 3)
    }

    test("platesBetweenCandles2") {

        val s = "***|**|*****|**||**|*"
        val queries = arrayOf(
            intArrayOf(1, 17),
            intArrayOf(4, 5),
            intArrayOf(14, 17),
            intArrayOf(5, 11),
            intArrayOf(15, 16),
        )

        Solution().platesBetweenCandles(s, queries) shouldBe intArrayOf(9, 0, 0, 0, 0)
    }

    test("platesBetweenCandles3") {

        val s = "*|*||||**|||||||*||*||*||**|*|*||*"
        val queries = arrayOf(
            intArrayOf(0, 33),
        )

        Solution().platesBetweenCandles(s, queries) shouldBe intArrayOf(10)
    }
})
