package programmers.level0.q181872

class Solution {
    fun solution(myString: String, pat: String): String {
        var rightIndex = myString.lastIndexOf(pat)

        return myString.substring(0, rightIndex + pat.length)
    }
}