package leetcode.problems.q1319

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("makeConnected") {
        val connections = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3),
            intArrayOf(1, 2),
            intArrayOf(1, 3)
        )
        val n = 6

        Solution().makeConnected(n, connections) shouldBe 2
    }
})
