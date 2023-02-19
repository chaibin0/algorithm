package leetcode.q2281

import kotlin.math.min

class SolutionFail {
    fun totalStrength(strength: IntArray): Int {

        var answer = 0
        val strengthLength = strength.size
        val sumDp: Array<IntArray> = Array(strengthLength) {
            IntArray(strengthLength)
        }

        val minDp: Array<IntArray> = Array(strengthLength) {
            IntArray(strengthLength)
        }


        for (i in 0 until strengthLength) {
            sumDp[i][i] = strength[i]

            for (j in (i + 1) until strengthLength) {
                sumDp[i][j] = sumDp[i][j - 1] + strength[j]
            }
        }

        for (i in strength.indices) {
            minDp[i][i] = strength[i]
            answer += (sumDp[i][i] * minDp[i][i]).rem(MODULO)
            answer = answer.rem(MODULO)
        }

        for (i in 1 until strengthLength) {
            for (j in 0 until (strengthLength - i)) {
                minDp[j][j + i] = min(minDp[j][j + i - 1], minDp[j + i][j + i])
                answer += (sumDp[j][j + i] * minDp[j][j + i]).rem(MODULO)
                answer = answer.rem(MODULO)
            }
        }

        return answer
    }

    companion object {
        const val MODULO = 1_000_000_000 + 7
    }
}