package leetcode.q472

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("findAllConcatenatedWordsInADict") {

        val words = arrayOf("cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat")
        Solution().findAllConcatenatedWordsInADict(words) shouldBe listOf("catsdogcats", "dogcatsdog", "ratcatdogcat")
    }
})
