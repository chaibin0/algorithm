package leetcode.q1085

class Solution {
    fun sumOfDigits(nums: IntArray): Int {

        var minimumValue = nums.min()
        var sum = 0
        while (minimumValue != 0) {
            val digit = minimumValue % 10
            minimumValue /= 10
            sum += digit
        }

        return if (sum % 2 == 0) 1 else 0
    }
}