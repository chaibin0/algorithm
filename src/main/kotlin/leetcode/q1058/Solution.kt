package leetcode.q1058

import java.util.PriorityQueue

class Solution {

    companion object {
        const val UNIT = 1000
    }

    fun minimizeError(prices: Array<String>, target: Int): String {
        val visit = BooleanArray(prices.size)
        val floorPriorityQueue =
            PriorityQueue<Pair<Int, Int>>(Comparator<Pair<Int, Int>> { p1, p2 -> p1.second - p2.second })
        val ceilPriorityQueue =
            PriorityQueue<Pair<Int, Int>>(Comparator<Pair<Int, Int>> { p1, p2 -> p1.second - p2.second })
        var remainTarget = target

        for ((index, price) in prices.withIndex()) {
            val decimalPrice = (price.toDouble() * UNIT).toInt()

            if ((decimalPrice % UNIT) == 0) {
                remainTarget -= decimalPrice
                visit[index] = true
                continue
            }

            val p = decimalPrice / UNIT
            val remain = decimalPrice % UNIT
            remainTarget -= p

            floorPriorityQueue.add(index to remain)
            ceilPriorityQueue.add(index to (UNIT - remain))
        }

        val size = floorPriorityQueue.size
        val needCeilSize = remainTarget

        if (needCeilSize > size || needCeilSize < 0) {
            return "-1"
        }

        val needFloorSize = size - needCeilSize

        var currentCeil = 0
        var currenFloor = 0
        var result = 0

        while (currentCeil < needCeilSize && currenFloor < needFloorSize) {
            while (floorPriorityQueue.isNotEmpty() && visit[floorPriorityQueue.peek().first]) {
                floorPriorityQueue.remove()
            }

            while (ceilPriorityQueue.isNotEmpty() && visit[ceilPriorityQueue.peek().first]) {
                ceilPriorityQueue.remove()
            }
            val (floorIndex, floorValue) = floorPriorityQueue.peek()
            val (ceilIndex, ceilValue) = ceilPriorityQueue.peek()

            if (floorIndex == ceilIndex) {
                floorPriorityQueue.remove()
                ceilPriorityQueue.remove()
                result += floorValue
                currenFloor++
                visit[floorIndex] = true
                continue
            }

            if (floorValue < ceilValue) {
                floorPriorityQueue.remove()
                result += floorValue
                currenFloor++
                visit[floorIndex] = true
                continue
            }

            ceilPriorityQueue.remove()
            visit[ceilIndex] = true
            result += ceilValue
            currentCeil++
        }

        while (currentCeil < needCeilSize) {

            val (ceilIndex, ceilValue) = ceilPriorityQueue.poll()

            if (visit[ceilIndex]) {
                continue
            }

            result += ceilValue
            currentCeil++

        }

        while (currenFloor < needFloorSize) {

            val (floorIndex, floorValue) = floorPriorityQueue.poll()

            if (visit[floorIndex]) {
                continue
            }

            result += floorValue
            currenFloor++
        }
        // 0001
        val sb = StringBuilder()
        if (result < 10) {
            sb.append("000")
        } else if (result < 100) {
            sb.append("00")
        } else if (result < 1000) {
            sb.append("0")
        }
        sb.append(result)

        sb.insert(sb.length - 3, '.')

        return sb.toString()
    }
}