package leetcode.q758

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val words = arrayOf("ace", "b", "adb", "ea", "ba")
        val s = "cdbbadeaec"

        Solution().boldWords(words, s) shouldBe "cd<b>bba</b>d<b>ea</b>ec"

    }
})
