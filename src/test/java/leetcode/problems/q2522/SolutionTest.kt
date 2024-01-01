package leetcode.problems.q2522

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val s = "2995624428278123422153476983795874268215311982758939386251"
        val k = 128
        Solution().minimumPartition(s, k) shouldBe 29
    }
})
