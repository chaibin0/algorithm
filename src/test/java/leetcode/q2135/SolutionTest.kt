package leetcode.q2135

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {

        val startWords = arrayOf("ant", "act", "tack")
        val targetWords = arrayOf("tack", "act", "acti")

        Solution().wordCount(startWords, targetWords) shouldBe 2
    }

    test("case2") {

        val startWords = arrayOf("g","vf","ylpuk","nyf","gdj","j","fyqzg","sizec")
        val targetWords = arrayOf("r","am","jg","umhjo","fov","lujy","b","uz","y")

        Solution().wordCount(startWords, targetWords) shouldBe 2
    }
})
