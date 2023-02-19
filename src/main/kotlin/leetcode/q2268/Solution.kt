package leetcode.q2268


class Solution {
    fun minimumKeypresses(s: String): Int {
        var answer = 0
        val keyMap: MutableMap<Char, Int> = mutableMapOf()

        for (c in s) {
            keyMap[c] = keyMap[c]?.plus(1) ?: 1
        }

        val sortedKeyMap: List<Pair<Char, Int>> = keyMap.toList().sortedByDescending { it.second }
        var current = 1
        var number = 1

        for ((_, count) in sortedKeyMap) {

            answer += (count * number)
            if (current % 9 == 0) {
                current = 0
                number++
            }
            current++
        }

        return answer
    }
}