package leetcode.q503

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("nextGreaterElements") {
        Solution().nextGreaterElements(intArrayOf(1, 2, 1)) shouldBe intArrayOf(2, -1, 2)
    }
})
