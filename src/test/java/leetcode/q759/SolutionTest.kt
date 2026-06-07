package leetcode.q759

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("employeeFreeTime") {
        val schedules = arrayListOf(
            arrayListOf(
                Interval(1, 2),
                Interval(5, 6),
                Interval(1, 3)
            ),
            arrayListOf(
                Interval(4, 10)
            )
        )

        Solution().employeeFreeTime(schedules) shouldBe arrayListOf(Interval(3, 4))
    }
})
