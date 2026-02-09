package leetcode.q3387

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val initialCurrency = "EUR"
        val pairs1 = listOf(
            listOf("EUR", "USD"),
            listOf("USD", "JPY"),
        )

        val rates1 = doubleArrayOf(2.0, 3.0)

        val pairs2 = listOf(
            listOf("JPY", "USD"),
            listOf("USD", "CHF"),
            listOf("CHF", "EUR"),
        )
        val rates2 = doubleArrayOf(4.0, 5.0, 6.0)

        Solution().maxAmount(initialCurrency, pairs1, rates1, pairs2, rates2) shouldBe 720.0
    }
})
