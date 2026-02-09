package leetcode.q813

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("largestSumOfAverages") {

        val nums = intArrayOf(9, 1, 2, 3, 9)
        val k = 3
        Solution().largestSumOfAverages(nums, k) shouldBe 20.0
    }

    test("largestSumOfAverages2") {

        val nums = intArrayOf(1,2,3,4,5,6,7)
        val k = 4
        Solution().largestSumOfAverages(nums, k) shouldBe 20.5
    }
})
