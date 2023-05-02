package leetcode.q907

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("sumSubarrayMins1") {

        val arr = intArrayOf(3, 1, 2, 4)
        Solution().sumSubarrayMins(arr) shouldBe 17
    }

    test("sumSubarrayMins2") {

        val arr = intArrayOf(11, 81, 94, 43, 3)
        Solution().sumSubarrayMins(arr) shouldBe 444
    }
})
