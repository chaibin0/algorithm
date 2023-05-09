package programmers.level0.q181909

class Solution {
    fun solution(my_string: String): Array<String> {

        val list = mutableListOf<String>()

        for (i in 0 until my_string.length) {
            list.add(my_string.subSequence(i, my_string.length).toString())
        }
        list.sort()
        return list.toTypedArray()
    }
}