package leetcode.q524

class Solution {
    fun findLongestWord(s: String, dictionary: List<String>): String {
        (dictionary as MutableList).sortWith { i, j ->
            if (i.length == j.length) {
                return@sortWith i.compareTo(j)
            }

            return@sortWith j.length.compareTo(i.length)
        }

        for (dict in dictionary) {

            var i = 0
            var j = 0
            while (i < s.length && j < dict.length) {
                if (s[i] == dict[j]) {
                    i++
                    j++
                    continue
                }
                i++
            }

            if (j == dict.length) {
                return dict
            }
        }

        return ""
    }
}