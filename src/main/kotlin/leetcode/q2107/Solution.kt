package leetcode.q2107

class Solution {
    fun shareCandies(candies: IntArray, k: Int): Int {

        val map = mutableMapOf<Int, Int>()
        for (i in 0 until candies.size) {
            map[candies[i]] = map.getOrDefault(candies[i], 0) + 1
        }

        for (i in 0 until k) {
            val candy = map[candies[i]]!!
            if (candy > 1) {
                map[candies[i]] = candy - 1
            } else {
                map.remove(candies[i])
            }
        }

        var maxFlavor = map.size

        for (i in k until candies.size) {
            map[candies[i - k]] = map.getOrDefault(candies[i - k], 0) + 1
            val candy = map[candies[i]]!!
            if (candy > 1) {
                map[candies[i]] = candy - 1
            } else {
                map.remove(candies[i])
            }

            maxFlavor = maxOf(maxFlavor, map.size)
        }

        return maxFlavor
    }
}