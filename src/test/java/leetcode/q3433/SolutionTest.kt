package leetcode.q3433

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val numberOfUsers = 2
        val events = listOf(
            listOf("MESSAGE", "10", "id1 id0"),
            listOf("OFFLINE", "11", "0"),
            listOf("MESSAGE", "71", "HERE"),
        )

        Solution().countMentions(numberOfUsers, events) shouldBe intArrayOf(2, 2)
    }

    test("case3") {
        val numberOfUsers = 2
        val events = listOf(
            listOf("OFFLINE", "10", "0"),
            listOf("MESSAGE", "12", "HERE")
        )

        Solution().countMentions(numberOfUsers, events) shouldBe intArrayOf(2, 2)
    }

    test("case4") {
        val numberOfUsers = 3
        val events = listOf(
            listOf("MESSAGE", "2", "HERE"),
            listOf("OFFLINE", "2", "1"),
            listOf("OFFLINE", "1", "0"),
            listOf("MESSAGE", "61", "HERE")
        )

        Solution().countMentions(numberOfUsers, events) shouldBe intArrayOf(1, 0, 2)
    }
})
