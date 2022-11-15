package leetcode.q547

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("findCircleNum") {

        val isConnected = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 1)
        )

        Solution().findCircleNum(isConnected) shouldBe 2

    }

    test("findCircleNum2") {

        val isConnected = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1)
        )

        Solution().findCircleNum(isConnected) shouldBe 3

    }
})
