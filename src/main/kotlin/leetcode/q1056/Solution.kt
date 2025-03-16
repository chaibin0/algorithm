package leetcode.q1056

class Solution {

    companion object {
        val validSet = hashSetOf(0, 1, 6, 8, 9)
    }
    // 89
    fun confusingNumber(n: Int): Boolean {
        var confusingNumber = false

        val numArray = n.toString()
            .toCharArray()
        val size = numArray.size / 2
        for (i in 0..size) {

            val j = numArray.lastIndex - i

            val current = numArray[i].digitToInt()  // 8
            val reverse = numArray[j].digitToInt()  // 9

            if (!validSet.contains(current) || !validSet.contains(reverse)) {
                return false
            }

            if ((current == 6 || current == 9) &&
                ((current == 6 && reverse != 9) ||
                        (current == 9 && reverse != 6))
            ) {
                confusingNumber = true
            }

            if (current != 6 && reverse != 9 && current != reverse) {
                confusingNumber = true
            }
        }

        return confusingNumber
    }
}