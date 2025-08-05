package leetcode.q451

import java.util.TreeMap

class Solution {
    fun frequencySort(s: String): String {
        val map = TreeMap<Char, Int>()

        for (c in s) {
            map[c] = map.getOrDefault(c, 0) + 1
        }

        val list = mutableListOf<Pair<Char, Int>>()

        for ((char, count) in map) {
            list.add(char to count)
        }

        list.sortWith { o1, o2 ->
            if (o1.second == o2.second) {
                return@sortWith o2.first.compareTo(o1.first)
            }

            return@sortWith o2.second.compareTo(o1.second)
        }

        val sb = StringBuilder()
        for ((char, count) in list) {
            for (i in 0 until count) {
                sb.append(char)
            }
        }

        return sb.toString()
    }
}