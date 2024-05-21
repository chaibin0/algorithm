package leetcode.q785

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val graph = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(0, 2),
            intArrayOf(1, 3),
            intArrayOf(0, 3),
        )

        Solution().isBipartite(graph) shouldBe true
    }

    test("case2") {
        val graph = arrayOf(
            intArrayOf(4),
            intArrayOf(),
            intArrayOf(4),
            intArrayOf(4),
            intArrayOf(0, 2, 3),
        )

        Solution().isBipartite(graph) shouldBe true
    }

    test("case3") {
        val graph = arrayOf(
            intArrayOf(4, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 4),
            intArrayOf(3, 0),
        )

        Solution().isBipartite(graph) shouldBe true
    }
})
