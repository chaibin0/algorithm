package programmers.level0.q181844

class Solution {
    fun solution(arr: IntArray, delete_list: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        for(a in arr){
            if(delete_list.contains(a)){
                continue
            }

            answer.add(a)
        }
        return answer.toIntArray()
    }
}