package leetcode.q1405

import java.util.PriorityQueue

class Solution {

    val sb = StringBuilder()

    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val length = a + b + c

        val pq = PriorityQueue<Pair<Int, Char>>()

        if (a != 0) {
            pq.add(Pair(a, 'a'))
        }

        if (b != 0) {
            pq.add(Pair(b, 'b'))
        }

        if (c != 0) {
            pq.add(Pair(c, 'c'))
        }

        var flag = true
        var count = 0
        var lastChar = 'z'
        val answer = StringBuilder()
        while (flag) {

//            if (pq.isNotEmpty()) {
//                var (firstLength, firstChar) = pq.first()
//                if (count < 2) {
//
//                }
//            }
//
//            if (count < 2) {
//                lastChar = firstChar
//                answer.append(firstChar)
//            }
//
//            var (secondLength, secondChar) = pq.poll()
//            var (thirdLength, thirdChar) = list[2]
//
//
//            if (lastChar == firstChar) {
//                secondCha
//            }
        }
        return sb.toString()
    }


}