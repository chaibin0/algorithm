package leetcode.q291

class Solution {

    val map = mutableMapOf<Char, String>()
    val set = mutableSetOf<String>()

    fun wordPatternMatch(pattern: String, s: String): Boolean {

        return dfs(0, 0, pattern, s)
    }

    fun dfs(currentPatternIndex: Int, currentPosition: Int, pattern: String, s: String): Boolean {
        if (s.length == currentPosition && currentPatternIndex == pattern.length) {
            return true
        }

        if (s.length <= currentPosition || pattern.length <= currentPatternIndex) {
            return false
        }

        val isInit = map.containsKey(pattern[currentPatternIndex])

        if (!isInit) {
            var word = StringBuilder()
            for (i in currentPosition until s.length) {
                word.append(s[i])
                if (set.contains(word.toString())) {
                    continue
                }

                map[pattern[currentPatternIndex]] = word.toString()
                set.add(word.toString())
                if (dfs(currentPatternIndex + 1, currentPosition + word.length, pattern, s)) {
                    return true
                }
                map.remove(pattern[currentPatternIndex])
                set.remove(word.toString())
            }

            return false
        }

        val currentPatternValue = map[pattern[currentPatternIndex]]!!
        if (currentPosition + currentPatternValue.length <= s.length &&
            s.substring(currentPosition, currentPosition + currentPatternValue.length) == currentPatternValue &&
            dfs(currentPatternIndex + 1, currentPosition + currentPatternValue.length, pattern, s)
        ) {
            return true
        }

        return false
    }
}