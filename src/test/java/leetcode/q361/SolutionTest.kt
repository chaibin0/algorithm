package leetcode.q361

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("maxKilledEnemies") {
        val grid = arrayOf(
            charArrayOf('0', 'E', '0', '0'),
            charArrayOf('E', '0', 'W', 'E'),
            charArrayOf('0', 'E', '0', '0')
        )
        Solution().maxKilledEnemies(grid) shouldBe 3
    }
})
