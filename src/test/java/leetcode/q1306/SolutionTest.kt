package leetcode.q1306

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("canReach") {

        val arr = intArrayOf(0, 1)
        val start = 1
        Solution().canReach(arr, start) shouldBe true
    }
})
