package leetcode.q3991

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val nums = intArrayOf(2, 0, 1)
        val pre = intArrayOf(2, 3)

        Solution().sortArray(nums, pre) shouldBe 2
    }

    test("case2") {
        val nums = intArrayOf(1, 0, 2)
        val pre = intArrayOf(1, 3)

        Solution().sortArray(nums, pre) shouldBe -1
    }
})
