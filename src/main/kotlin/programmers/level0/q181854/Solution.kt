package programmers.level0.q181854

class Solution {
    fun solution(arr: IntArray, n: Int): IntArray {
        var answer = mutableListOf<Int>()

        var startPosition = if (arr.size % 2 == 0) 1 else 0

        for (i in startPosition until arr.size) {
            answer.add(arr[i])
        }
        return answer.toIntArray()
    }
}