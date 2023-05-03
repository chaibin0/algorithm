package programmers.level0.q181864

class Solution {
    fun solution(myString: String, pat: String): Int {
        val changedPat = pat.map {
            if (it == 'A') 'B' else 'A'
        }.joinToString("")
        return if (myString.contains(changedPat)) 1 else 0
    }
}
