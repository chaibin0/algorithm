package leetcode.q18

class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val answer = mutableSetOf<List<Int>>()

        for (i in 0 until (nums.size - 3)) {
            for (j in i + 1 until (nums.size - 2)) {
                for (k in j + 1 until (nums.size - 1)) {
                    for (q in k + 1 until nums.size) {
                        if (nums[i].toLong() + nums[j].toLong() + nums[k].toLong() + nums[q].toLong() == target.toLong()) {
                            answer.add(listOf(nums[i], nums[j], nums[k], nums[q]))
                            break
                        }
                    }
                }
            }
        }

        return answer.toList()
    }
}