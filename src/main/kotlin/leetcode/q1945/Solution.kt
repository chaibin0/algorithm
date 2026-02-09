package leetcode.q1945

class Solution {
    fun getLucky(s: String, k: Int): Int {

        // convert
        val sb = StringBuilder()
        for (c in s) {
            sb.append(c - 'a' + 1)
        }
        // transform #k
        var current = sb
        repeat(k) {
            var value = 0
            current.forEach { value += it.digitToInt() }
            current = StringBuilder().apply { this.append(value) }
        }

        return current.toString().toInt()
    }
}