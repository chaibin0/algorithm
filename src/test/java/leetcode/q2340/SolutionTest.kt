package leetcode.q2340

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("minimumSwaps") {
        Solution().minimumSwaps(intArrayOf(3, 4, 5, 5, 3, 1)) shouldBe 6
    }
})
