package leetcode.q165

import kotlin.math.min

class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        val v1 = version1.split(".").map(String::toInt)
        val v2 = version2.split(".").map(String::toInt)

        val length = min(v1.size, v2.size)
        var i = 0

        while (i < length) {
            if (v1[i] > v2[i]) {
                return 1
            }
            if (v1[i] < v2[i]) {
                return -1
            }
            i++
        }

        if (v1.size == v2.size) {
            return 0
        }

        while (i < v1.size) {
            if (v1[i] != 0) {
                return 1
            }
            i++
        }

        while (i < v2.size) {
            if (v2[i] != 0) {
                return -1
            }
            i++
        }

        return 0
    }
}