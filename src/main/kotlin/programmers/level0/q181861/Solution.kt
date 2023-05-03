package programmers.level0.q181861

class Solution {
    fun solution(arr: IntArray): IntArray {

        val answer = mutableListOf<Int>()

        for (i in arr) {
            for (count in 0 until i) {
                answer.add(i)
            }
        }

        return answer.toIntArray()
    }
}