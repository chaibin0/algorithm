package programmers.level0.q181886

class Solution {
    fun solution(names: Array<String>): Array<String> {

        val groupSize = names.size / 5
        var list = mutableListOf<String>()
        for (i in 0..groupSize) {
            list.add(names[i * 5])
        }
        return list.toTypedArray()
    }
}