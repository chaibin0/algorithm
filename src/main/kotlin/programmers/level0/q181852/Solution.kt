package programmers.level0.q181852

class Solution {
    fun solution(num_list: IntArray): IntArray {
        num_list.sortDescending()
        return num_list.copyOfRange(0, 5)
    }
}