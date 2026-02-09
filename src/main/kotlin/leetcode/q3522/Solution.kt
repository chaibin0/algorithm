package leetcode.q3522

class Solution {
    fun calculateScore(instructions: Array<String>, values: IntArray): Long {
        var index = 0
        var result = 0L
        val visit = BooleanArray(instructions.size)
        while (true) {
            val currentIndex = index
            if (instructions[currentIndex] == "jump") {
                index += values[index]
            } else {
                index++
            }

            if (instructions[currentIndex] == "add") {
                result += values[currentIndex]
            }

            if (index < 0 || index >= instructions.size || visit[index]) {
                break
            }

            visit[currentIndex] = true
        }

        return result
    }
}