package programmers.level0.q181875

class Solution {
    fun solution(strArr: Array<String>): Array<String> {
        return strArr.mapIndexed { index, s ->  if(index % 2 == 1) s.uppercase() else s.lowercase()}.toTypedArray()
    }
}