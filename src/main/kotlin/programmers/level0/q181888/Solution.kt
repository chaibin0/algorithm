package programmers.level0.q181888

class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {

        return num_list.filterIndexed { index, i ->  index % n == 0}.toIntArray()
    }
}