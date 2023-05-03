package programmers.level0.q181928


class Solution {
    fun solution(num_list: IntArray): Int {
        var oddSb = StringBuilder()
        var evenSb = StringBuilder()

        for(num in num_list) {
            if(num % 2 == 0){
                evenSb.append(num)
            } else {
                oddSb.append(num)
            }
        }

        return evenSb.toString().toInt() + oddSb.toString().toInt()
    }
}