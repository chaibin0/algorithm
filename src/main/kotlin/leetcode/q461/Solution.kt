package leetcode.q461

class Solution {
    fun hammingDistance(x: Int, y: Int): Int {
        var currentX = x
        var currentY = y
        var answer = 0
        while (currentX != 0 || currentY != 0) {

            if (currentX.and(1).xor(currentY.and(1)) == 1) {
                answer++
            }

            currentX = currentX.shr(1)
            currentY = currentY.shr(1)
        }

        return answer
    }
}