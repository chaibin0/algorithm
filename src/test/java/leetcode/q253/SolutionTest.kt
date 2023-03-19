package leetcode.q253

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("minMeetingRooms") {

        val intervals = arrayOf(
            intArrayOf(0, 30),
            intArrayOf(5, 10),
            intArrayOf(15, 20)
        )

        Solution().minMeetingRooms(intervals) shouldBe 2
    }
})
