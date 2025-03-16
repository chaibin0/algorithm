package leetcode.q3170

import java.util.*
import kotlin.Comparator

class Solution {
    fun clearStars(s: String): String {
        val pq = PriorityQueue<Data>(Comparator { p1, p2 ->
            if (p1.char == p2.char) {
                return@Comparator p2.index - p1.index
            }
            return@Comparator p1.char - p2.char
        })

        val strArray = s.toCharArray()
        for ((index, char) in s.withIndex()) {
            if (char != '*') {
                pq.add(Data(char, index))
                continue
            }

            if (pq.isNotEmpty()) {
                val data = pq.poll()
                strArray[data.index] = '*'
            }
        }

        val sb = StringBuilder()
        for (char in strArray) {
            if (char != '*') {
                sb.append(char)
            }
        }

        return sb.toString()
    }
}

data class Data(
    val char: Char,
    val index: Int
)