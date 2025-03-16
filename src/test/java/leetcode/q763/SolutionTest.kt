package leetcode.q763

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("partitionLabels") {
        val s = "ababcbacadefegdehijhklij"
        Solution().partitionLabels(s) shouldBe intArrayOf(9, 7, 8)
    }
})
