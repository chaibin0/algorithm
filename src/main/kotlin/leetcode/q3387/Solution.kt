package leetcode.q3387

import kotlin.math.max

class Solution {
    val day1: MutableMap<String, MutableList<Pair<String, Double>>> = mutableMapOf()
    val day2: MutableMap<String, MutableList<Pair<String, Double>>> = mutableMapOf()
    var answer = 1.0
    lateinit var initialCurrency: String
    fun maxAmount(
        initialCurrency: String,
        pairs1: List<List<String>>,
        rates1: DoubleArray,
        pairs2: List<List<String>>,
        rates2: DoubleArray
    ): Double {

        this.initialCurrency = initialCurrency
        for ((index, pair) in pairs1.withIndex()) {
            val (startCurrency, targetCurrency) = pair
            if (day1.containsKey(startCurrency)) {
                day1.getValue(startCurrency).add(targetCurrency to rates1[index])
            } else {
                day1[startCurrency] = mutableListOf(targetCurrency to rates1[index])
            }

            if (day1.containsKey(targetCurrency)) {
                day1.getValue(targetCurrency).add(startCurrency to 1 / rates1[index])
            } else {
                day1[targetCurrency] = mutableListOf(startCurrency to 1 / rates1[index])
            }
        }

        for ((index, pair) in pairs2.withIndex()) {
            val (startCurrency, targetCurrency) = pair
            if (day2.containsKey(startCurrency)) {
                day2.getValue(startCurrency).add(targetCurrency to rates2[index])
            } else {
                day2[startCurrency] = mutableListOf(targetCurrency to rates2[index])
            }

            if (day2.containsKey(targetCurrency)) {
                day2.getValue(targetCurrency).add(startCurrency to 1 / rates2[index])
            } else {
                day2[targetCurrency] = mutableListOf(startCurrency to 1 / rates2[index])
            }
        }

        val visit = mutableSetOf<Pair<String, Boolean>>()

        dfs(initialCurrency, 1.0, visit, false)
        return answer
    }

    fun dfs(
        currentCurrency: String,
        currentRate: Double,
        visit: MutableSet<Pair<String, Boolean>>,
        isDay2: Boolean
    ) {
        if (currentCurrency == initialCurrency) {
            answer = max(answer, currentRate)
        }

        if (!isDay2 && day1.containsKey(currentCurrency)) {
            for ((targetCurrency, targetRate) in day1[currentCurrency]!!) {
                if (visit.contains(Pair(targetCurrency, false))) {
                    continue
                }

                val visitValue = Pair(targetCurrency, false)
                visit.add(visitValue)
                dfs(targetCurrency, currentRate * targetRate, visit, false)
                visit.remove(visitValue)
            }
        }
        if (day2.containsKey(currentCurrency)) {

            for ((targetCurrency, targetRate) in day2[currentCurrency]!!) {
                if (visit.contains(Pair(targetCurrency, true))) {
                    continue
                }

                val visitValue = Pair(targetCurrency, true)
                visit.add(visitValue)
                dfs(targetCurrency, currentRate * targetRate, visit, true)
                visit.remove(visitValue)
            }
        }
    }
}