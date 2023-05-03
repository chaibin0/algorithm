package programmers.level0.q181927

class Solution {
    fun solution(num_list: IntArray): IntArray {
        var answer: IntArray = num_list.copyOf(num_list.size + 1)
        answer[answer.lastIndex] =
            if (num_list.last() > num_list[num_list.lastIndex - 1]) num_list.last() - num_list[num_list.lastIndex - 1] else num_list.last() * 2
        return answer
    }
}