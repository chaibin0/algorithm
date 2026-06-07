package leetcode.q2115

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val recipes = arrayOf("bread", "sandwich")
        val ingredients = listOf(listOf("yeast", "sandwich"), listOf("bread", "yeast"))
        val supplies = arrayOf("yeast")

        Solution().findAllRecipes(recipes, ingredients, supplies) shouldBe emptyList()
    }
})
