package leetcode.q1394

class Solution {
    fun findLucky(arr: IntArray): Int {
        val frequencyArr = IntArray(501) { 0 }
        for (i in arr) {
            frequencyArr[i]++
        }

        for (i in 500 downTo 1) {
            if (frequencyArr[i] == i) {
                return i
            }
        }

        return -1
    }
}