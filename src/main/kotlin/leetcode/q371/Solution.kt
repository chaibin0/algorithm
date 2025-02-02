package leetcode.q371

import kotlin.math.abs

class Solution {
    fun getSum(a: Int, b: Int): Int {

        val (big, small) = if (abs(a) > abs(b)) {
            a to b
        } else {
            b to a
        }

        if ((a >= 0 && b >= 0) || (a <= 0 && b <= 0)) {
            return plus(big, small)
        }

        return minus(big, small)
    }

    fun plus(a: Int, b: Int): Int {
        val isPlus = (a >= 0 && b >= 0)
        var answer = 0
        var currentA = abs(a)
        var currentB = abs(b)
        var bitA: Int
        var bitB: Int
        var carry = 0
        var index = 0
        while (carry != 0 || currentA != 0 || currentB != 0) {
            bitA = currentA.and(1)
            bitB = currentB.and(1)

            val value = carry.xor(bitA).xor(bitB)
            answer = answer.or(value.rotateLeft(index))

            carry = if ((bitA == 1 && bitB == 1) || (bitA == 1 && carry == 1) || (bitB == 1 && carry == 1)) {
                1
            } else {
                0
            }

            index++
            currentA = currentA.shr(1)
            currentB = currentB.shr(1)
        }

        return if (isPlus) answer else -answer
    }

    fun minus(a: Int, b: Int): Int {
        val isPlus = a >= b
        var answer = 0
        var currentA = abs(a)
        var currentB = abs(b)
        var bitA: Int
        var bitB: Int
        var carry = 0
        var index = 0
        while (currentA != 0 || currentB != 0) {
            bitA = currentA.and(1)
            bitB = currentB.and(1)

            val value = carry.xor(bitA).xor(bitB)
            answer = answer.or(value.rotateLeft(index))

            carry = if ((bitB == 0 && carry == 0) || (bitA == 1 && carry == 0 && bitB == 1)) {
                0
            } else {
                1
            }

            index++
            currentA = currentA.shr(1)
            currentB = currentB.shr(1)
        }

        return if (isPlus) answer else -answer
    }
}