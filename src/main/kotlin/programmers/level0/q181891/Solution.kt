package programmers.level0.q181891

class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        val answer = mutableListOf<Int>()
        for (i in n until num_list.size) {
            answer.add(num_list[i])
        }
        for (i in 0 until n) {
            answer.add(num_list[i])
        }
        return answer.toIntArray()
    }
}