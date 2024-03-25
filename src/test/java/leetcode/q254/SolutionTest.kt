package leetcode.q254

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("getFactors") {

        val n = 12

        Solution().getFactors(n) shouldContain listOf(
            listOf(2, 6),
            listOf(3, 4),
            listOf(2, 2, 3)
        )

    }

    test("getFactors2") {

        val n = 32

        Solution().getFactors(n) shouldContain listOf(
            listOf(2, 6),
            listOf(3, 4),
            listOf(2, 2, 3)
        )

    }

    test("getFactors3") {

        val n = 4

        Solution().getFactors(n) shouldContain listOf(
            listOf(2, 2)
        )

    }
})
