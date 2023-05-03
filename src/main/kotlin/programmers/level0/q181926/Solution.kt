package programmers.level0.q181926

class Solution {
    fun solution(n: Int, control: String): Int {
        var answer: Int = n
        for (c in control) {
            answer += when (c) {
                'w' -> 1
                's' -> -1
                'd' -> 10
                'a' -> -10
                else -> 0
            }
        }
        return answer
    }
}