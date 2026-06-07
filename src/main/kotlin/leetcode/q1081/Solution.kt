package leetcode.q1081

class Solution {

    var answer = ('z' + 1).toString()
    var isFind = false
    var distinctChars = 0

    fun smallestSubsequence(s: String): String {

        distinctChars = s.toSet().size
        val visited = mutableSetOf<Char>()

        for ((index, c) in s.withIndex()) {
            if (visited.contains(c)) {
                continue
            }
            visited.add(c)

            if (isFind && answer[0] < c) {
                continue
            }

            val sb = StringBuilder()
            sb.append(c)
            nextSubsequence(sb.toString(), mutableSetOf(c), index + 1, s)
        }

        return answer
    }

    private fun nextSubsequence(currentS: String, currentSet: MutableSet<Char>, index: Int, s: String) {

        val sb = StringBuilder(currentS)

        for (j in (index until s.length)) {

            if (currentSet.contains(s[j])) {
                if (sb.length != distinctChars) {
                    nextSubsequence(sb.toString(), currentSet, index + 1, s)
                }

                while (currentSet.contains(s[j])) {
                    val last = sb.last()
                    sb.deleteCharAt(sb.lastIndex)
                    currentSet.remove(last)
                }
            }

            currentSet.add(s[j])
            sb.append(s[j])

            if (sb.length == distinctChars) {
                answer = minOf(answer, sb.toString())
                isFind = true
                continue
            }
        }

    }

}