package leetcode.q311

class Solution {
    fun multiply(mat1: Array<IntArray>, mat2: Array<IntArray>): Array<IntArray> {
        val y1 = mat1.size
        val x1 = mat1[0].size
        val y2 = mat2.size
        val x2 = mat2[0].size

        val answer = Array(y1) { IntArray(x2) }

        for (y in 0 until y1) {
            for (x in 0 until x2) {
                var value = 0
                for (i in 0 until x1) {
                    value += mat1[y][i] * mat2[i][x]
                }

                answer[y][x] = value
            }
        }

        return answer
    }
}