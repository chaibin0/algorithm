package leetcode.problems.q1163

import java.util.*

class Solution {
    fun lastSubstring(s: String): String {
        val alphabetIndexTreeMap = TreeMap<Char, MutableList<Int>>(Comparator.reverseOrder())
        for ((index, c) in s.withIndex()) {
            alphabetIndexTreeMap.getOrPut(c) { mutableListOf() }.add(index)
        }

        val root = alphabetIndexTreeMap.firstKey()
        val rootTreeSet = TreeSet<Int>()
        for (index in alphabetIndexTreeMap[root]!!) {
            rootTreeSet.add(index)
        }

        var subTreeSet = rootTreeSet
        var currentTreeSet: TreeSet<Int>

        for (alphabet in alphabetIndexTreeMap.keys) {
            if (alphabet == root) {
                continue
            }

            var minDiff = s.length
            currentTreeSet = TreeSet<Int>()

            for (index in alphabetIndexTreeMap[alphabet]!!) {
                val ceiling = subTreeSet.floor(index) ?: continue
                val diff = index - ceiling
                if (minDiff > diff) {
                    currentTreeSet = TreeSet<Int>()
                    minDiff = diff
                }
                currentTreeSet.add(index)
            }

            subTreeSet = currentTreeSet
        }

        return s.substring(rootTreeSet.floor(subTreeSet.first())!!)
    }
}