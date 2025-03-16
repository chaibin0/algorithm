package leetcode.q702

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 *
 *
 *
 */

class ArrayReader(private val secret: IntArray) {

    fun get(index: Int): Int {
        if (secret.lastIndex < index) {
            return Int.MAX_VALUE
        }
        return secret[index]
    }
}

class Solution {

    fun search(reader: ArrayReader, target: Int): Int {

        var low = 0
        var high = 9999
        for (i in 0 until 14) {
            val mid = (low + high) / 2

            if (reader.get(mid) == Int.MAX_VALUE) {
                high = mid - 1
                continue
            }

            val value = reader.get(mid)

            if (value == target) {
                return mid
            }

            if (value > target) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }

        return -1
    }
}