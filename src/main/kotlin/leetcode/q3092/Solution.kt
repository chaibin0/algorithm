package leetcode.q3092

import java.util.*


class Solution {

    fun mostFrequentIDs(nums: IntArray, freq: IntArray): LongArray {
        val answer = LongArray(nums.size)
        val idToFreq = mutableMapOf<Int, Long>()
        val freqToId = TreeMap<Long, MutableSet<Int>>(Collections.reverseOrder())

        for (i in nums.indices) {
            val newFreq = freq[i].toLong()
            val id = nums[i]
            val nextFreq = (idToFreq[id] ?: 0) + newFreq

            if (idToFreq.containsKey(id)) {
                val ids = freqToId[idToFreq[id]]!!
                if (ids.size == 1) {
                    freqToId.remove(idToFreq[id])
                } else {
                    ids.remove(id)
                }
            }

            if (freqToId.containsKey(nextFreq)) {
                freqToId[nextFreq]!!.add(id)
            } else {
                freqToId[nextFreq] = mutableSetOf(id)
            }

            idToFreq[id] = nextFreq
            answer[i] = freqToId.firstKey()
        }

        return answer
    }
}

