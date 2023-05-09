package programmers.level0.q181872

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("solution") {

        val myString = "AbCdEFG"
        val pat = "dE"
        Solution().solution(myString, pat) shouldBe "AbCdE"
    }

    test("solution2") {

        val myString = "AAAAaaaa"
        val pat = "a"
        Solution().solution(myString, pat) shouldBe "AAAAaaaa"
    }
})
