package leetcode.q166

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("fractionToDecimal") {
        val numerator = -2147483648
        val denominator = 1
        Solution().fractionToDecimal(numerator, denominator) shouldBe "-2147483648"
    }
})
