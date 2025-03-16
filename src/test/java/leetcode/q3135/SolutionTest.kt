package leetcode.q3135

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val initial = "iksch"
        val target = "wjoti"

        Solution().minOperations(initial, target) shouldBe 8
    }
})
