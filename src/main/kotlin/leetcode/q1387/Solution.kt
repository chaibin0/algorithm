package leetcode.q1387

class Solution {

    fun getKth(lo: Int, hi: Int, k: Int): Int {

        val order = arrayListOf<Pair<Int, Int>>()

        for (i in lo..hi) {
            val result = calculate(i)
            println(result)
            order.add(result to i)
        }

        order.sortWith { p1, p2 ->
            if (p1.first == p2.first)
                return@sortWith p1.second - p2.second
            else
                return@sortWith p1.first - p2.first
        }
        return order[k - 1].second
    }

    private fun calculate(num: Int): Int {
        var count = 0
        var current = num
        while (current != 1) {
            current = if (current % 2 == 0) {
                current / 2
            } else {
                current * 3 + 1
            }
            count++
        }

        return count
    }
}