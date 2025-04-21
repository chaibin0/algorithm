package leetcode.q2061

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {

        val room = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 0),
        )

        Solution().numberOfCleanRooms(room) shouldBe 7
    }

    test("case2") {

        val room = arrayOf(
            intArrayOf(0, 0, 0, 1),
            intArrayOf(0, 1, 0, 1),
            intArrayOf(1, 0, 0, 0),
        )

        Solution().numberOfCleanRooms(room) shouldBe 7
    }
})
