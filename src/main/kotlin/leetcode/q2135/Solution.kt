package leetcode.q2135

class Solution {
    fun wordCount(startWords: Array<String>, targetWords: Array<String>): Int {
        val bitmaskSet = hashSetOf<Int>()
        var answer = 0
        for (startWord in startWords) {
            var value = 0
            for (c in startWord) {
                value += 1.rotateLeft(c - 'a')
            }

            bitmaskSet.add(value)
        }

        for (targetWord in targetWords) {
            var value = 0
            for (c in targetWord) {
                value += 1.rotateLeft(c - 'a')
            }

            val maxValue = 1.rotateLeft(27) - 1
            for (i in 0 until 26) {

                val digit = 1.rotateLeft(i)
                if (digit > value) {
                    break
                }

                if (value.and(digit).rotateRight(i) == 0) {
                    continue
                }

                if (bitmaskSet.contains(value.and(maxValue.xor(digit)))) {
                    answer++
                    break
                }
            }
        }

        return answer
    }
}