package leetcode.q3843

class Solution {
    fun firstUniqueFreq(nums: IntArray): Int {
        val numsToFreq = mutableMapOf<Int, Int>()
        for (num in nums) {
            numsToFreq[num] = numsToFreq.getOrDefault(num, 0) + 1
        }
        // 10 -> 2
        // 20 -> 2

        val freqToFreq = mutableMapOf<Int, MutableSet<Int>>()
        for ((num, freq) in numsToFreq.entries) {
            freqToFreq.getOrPut(freq) { mutableSetOf() }.add(num)
        }

        //  2 -> (10, 20)
        //  3 -> (40)

        val uniqueFreq = mutableSetOf<Int>()

        for ((freq, freqFreq) in freqToFreq.entries) {
            if (freqFreq.size == 1) {
                uniqueFreq.add(freq)
            }
        }

        if (uniqueFreq.isEmpty()) {
            return -1
        }

        for (num in nums) {
            if (uniqueFreq.contains(numsToFreq.getValue(num))) {
                return num
            }
        }

        return -1
    }
}

