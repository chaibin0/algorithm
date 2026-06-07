package leetcode.q3309

class Solution {

    val permutation = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(0, 2, 1),
        intArrayOf(1, 0, 2),
        intArrayOf(1, 2, 0),
        intArrayOf(2, 0, 1),
        intArrayOf(2, 1, 0),
    )

    fun maxGoodNumber(nums: IntArray): Int {
        var answer = 0

        val binaryNums = nums.map { it.toString(2) }

        for (list in permutation) {
            val concat = binaryNums[list[0]] + binaryNums[list[1]] + binaryNums[list[2]]
            answer = maxOf(answer, concat.toInt(2))
        }

        return answer
    }
}