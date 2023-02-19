package leetcode.q2214

import kotlin.math.max


class Solution {
    fun minimumHealth(damage: IntArray, armor: Int): Long {

        var answer = 0L
        var strongDamage = 0
        for (d in damage) {
            strongDamage = max(strongDamage, d)
            answer += d
        }

        answer -= if (strongDamage >= armor) armor else strongDamage
        return answer + 1
    }
}