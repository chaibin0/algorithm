package leetcode.q3092

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {

        val nums = intArrayOf(2, 3, 2, 1)
        val freq = intArrayOf(3, 2, -3, 1)

        Solution().mostFrequentIDs(nums, freq) shouldBe longArrayOf(3, 3, 2, 2)
    }
})
