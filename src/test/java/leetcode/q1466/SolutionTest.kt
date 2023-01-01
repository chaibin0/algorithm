package leetcode.q1466

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("minReorder") {
        val n = 6
        val connections = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(4, 0),
            intArrayOf(4, 5)
        )

        Solution().minReorder(n, connections) shouldBe 3
    }
})
