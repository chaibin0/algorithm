package leetcode.q3015

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        Solution().countOfPairs(5, 2, 4) shouldBe intArrayOf(10, 8, 2, 0, 0)

    }

})
