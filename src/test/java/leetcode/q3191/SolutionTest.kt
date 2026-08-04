package leetcode.q3191

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("minOperations") {
        Solution().minOperations(intArrayOf(0, 1, 1, 1, 0, 0)) shouldBe 3
    }
})
