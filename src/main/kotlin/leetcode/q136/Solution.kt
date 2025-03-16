package leetcode.q136

class Solution {
    fun singleNumber(nums: IntArray): Int {

        val numbers = hashSetOf<Int>()

        for (num in nums) {
            if (numbers.contains(num)) {
                numbers.remove(num)
                continue
            }

            numbers.add(num)
        }

        return numbers.single()
    }
}