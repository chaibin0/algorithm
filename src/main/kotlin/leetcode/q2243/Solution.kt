package leetcode.q2243

class Solution {
    fun digitSum(s: String, k: Int): String {
        var currentS = s

        while (currentS.length > k) {
            var i = 1
            val newCurrentS = StringBuilder()
            var currentValue = 0
            for (c in currentS) {
                currentValue += c.digitToInt()

                if (i == k) {
                    newCurrentS.append(currentValue)
                    currentValue = 0
                    i = 0
                }

                i++
            }

            if (i != 1) {
                newCurrentS.append(currentValue)
            }

            currentS = newCurrentS.toString()
        }

        return currentS
    }
}