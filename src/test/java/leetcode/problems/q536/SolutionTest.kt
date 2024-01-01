package leetcode.problems.q536

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val s = "4(2(3)(1))(6(5))"

        Solution().str2tree(s);
    }

    test("case2") {
        val s = "4"

        Solution().str2tree(s);
    }
})
