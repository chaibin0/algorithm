package leetcode.q1554

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("differByOne") {
        val dict = arrayOf("abcd", "acbd", "aacd")
        Solution().differByOne(dict) shouldBe true

    }
})
