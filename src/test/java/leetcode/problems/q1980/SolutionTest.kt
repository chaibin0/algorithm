package leetcode.problems.q1980

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val nums = arrayOf<String>("10", "01", "00")
        Solution().findDifferentBinaryString(nums) shouldBe "11"
    }

    test("case2") {
        val nums = arrayOf<String>("00", "01")
        Solution().findDifferentBinaryString(nums) shouldBe "10"
    }

    test("case3") {
        val nums = arrayOf<String>("00", "10")
        Solution().findDifferentBinaryString(nums) shouldBe "01"
    }
})
