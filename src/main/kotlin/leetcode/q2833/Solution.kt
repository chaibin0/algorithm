package leetcode.q2833

import kotlin.math.abs

class Solution {
    companion object {
        const val LEFT = 'L'
        const val RIGHT = 'R'
        const val CONTINUE = '_'
    }

    fun furthestDistanceFromOrigin(moves: String): Int {
        var distance = 0
        var unknownSize = 0
        for (move in moves) {
            when (move) {
                LEFT -> {
                    distance--
                }

                RIGHT -> {
                    distance++
                }

                CONTINUE -> {
                    unknownSize++
                }
            }
        }

        return abs(distance) + unknownSize
    }
}