package leetcode.q2244

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("minimumRounds") {

      val tasks = intArrayOf(66,66,63,61,63,63,64,66,66,65,66,65,61,67,68,66,62,67,61,64,66,60,69,66,65,68,63,60,67,62,68,60,66,64,60,60,60,62,66,64,63,65,60,69,63,68,68,69,68,61)

        Solution().minimumRounds(tasks) shouldBe 20

    }
})
