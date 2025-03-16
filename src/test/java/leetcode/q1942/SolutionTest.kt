package leetcode.q1942

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val times = arrayOf(
            intArrayOf(2, 4),
            intArrayOf(4, 9),
            intArrayOf(3, 4),
            intArrayOf(6, 8),
            intArrayOf(5, 10)
        )

        val targetFriend = 4

        Solution().smallestChair(times, targetFriend) shouldBe 1
    }
})
