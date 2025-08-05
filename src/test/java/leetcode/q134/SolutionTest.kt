package leetcode.q134

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {

        val gas = intArrayOf(1, 2, 3, 4, 5)
        val cost = intArrayOf(3, 4, 5, 1, 2)
        Solution().canCompleteCircuit(gas, cost) shouldBe 3
    }

    test("case2") {

        val gas = intArrayOf(1, 2, 3, 4, 5, 5, 70)
        val cost = intArrayOf(2, 3, 4, 3, 9, 6, 2)
        Solution().canCompleteCircuit(gas, cost) shouldBe 6
    }

    test("case3") {

        val gas = intArrayOf(2, 3, 4)
        val cost = intArrayOf(3, 4, 3)
        Solution().canCompleteCircuit(gas, cost) shouldBe -1
    }
})
