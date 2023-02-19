package leetcode.q2268

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("minimumKeypresses") {
      Solution().minimumKeypresses("abcdefghijkl") shouldBe 5
    }
})
