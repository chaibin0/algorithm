package programmers.level0.q181884

class Solution {
    fun solution(numbers: IntArray, n: Int): Int {
        var answer: Int = 0
        for (number in numbers) {
            if (answer < n) {
                break
            }

            answer += number
        }
        return answer
    }
}