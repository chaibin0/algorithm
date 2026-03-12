package leetcode.q2115

class Solution {
    fun findAllRecipes(recipes: Array<String>, ingredients: List<List<String>>, supplies: Array<String>): List<String> {
        val answer = mutableListOf<String>()
        val map = mutableMapOf<String, MutableList<Int>>()
        val ingredientCount = IntArray(recipes.size)
        for ((index, ingredientList) in ingredients.withIndex()) {
            for (ingredient in ingredientList) {
                map.getOrPut(ingredient) { mutableListOf() }.add(index)
            }
        }

        var recipeQueue = ArrayDeque<String>()

        for (supply in supplies) {

            val list = map[supply] ?: continue

            list.forEach { index ->
                ingredientCount[index]++
                if (ingredientCount[index] == ingredients[index].size) {
                    answer.add(recipes[index])
                    recipeQueue.add(recipes[index])
                }
            }
        }

        while (recipeQueue.isNotEmpty()) {
            val recipe = recipeQueue.removeFirst()
            val list = map[recipe] ?: continue
            list.forEach { index ->
                ingredientCount[index]++
                if (ingredientCount[index] == ingredients[index].size) {
                    answer.add(recipes[index])
                    recipeQueue.add(recipes[index])
                }
            }
        }

        return answer
    }
}