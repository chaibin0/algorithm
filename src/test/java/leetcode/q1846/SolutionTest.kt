package leetcode.q1846

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val arr = intArrayOf(100, 1, 1000)
        Solution().maximumElementAfterDecrementingAndRearranging(arr) shouldBe 3
    }
})
