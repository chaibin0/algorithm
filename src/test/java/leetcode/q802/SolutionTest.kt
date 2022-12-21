package leetcode.q802

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("eventualSafeNodes") {

        val graph = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(5),
            intArrayOf(0),
            intArrayOf(5),
            intArrayOf(),
            intArrayOf()
        )

        Solution().eventualSafeNodes(graph) shouldBe intArrayOf(2, 4, 5, 6)
    }
})
