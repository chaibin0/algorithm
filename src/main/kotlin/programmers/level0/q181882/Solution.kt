package programmers.level0.q181882

class Solution {
    fun solution(arr: IntArray): IntArray {
        return arr.map {
            if(it > 50 || it % 2 == 0) {
                it / 2
            } else {
                it * 2
            }
        }.toIntArray()
    }
}