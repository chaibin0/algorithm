package programmers.level0.q181853

class Solution {
    fun solution(num_list: IntArray): IntArray {
        num_list.sort()
        return num_list.copyOfRange(0, 5)
    }
}