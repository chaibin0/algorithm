package leetcode.problems.q1028

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({
    test("case1") {
        val traversal = "1-2--3--4-5--6--7"
        val result = Solution().recoverFromPreorder(traversal)

        println(result)
    }

    test("case2") {
        val traversal = "1-401--349---90--88"
        val result = Solution().recoverFromPreorder(traversal)

        println(result)
    }

})
