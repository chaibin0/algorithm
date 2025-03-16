package leetcode.q1764

class Solution {
    fun canChoose(groups: Array<IntArray>, nums: IntArray): Boolean {

        val groupString = groups.map {
            it.joinToString()
        }
        var ith = 0
        val numsList = nums.toList()
        var step = 1
        var i = 0
        while (i < numsList.size) {


            if (i + groups[ith].size > nums.size) {
                break
            }
            val numSubString = numsList.subList(i, i + groups[ith].size).joinToString()
            println("${i} ${numSubString}")
            if (groupString[ith] == numSubString) {
                i += groups[ith].size
                ith++
                if (ith == groups.size) {
                    break
                }
            } else {
                i++
            }
        }

        return ith == groups.size
    }
}