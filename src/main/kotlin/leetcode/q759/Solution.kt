package leetcode.q759

// Definition for an Interval.
class Interval {
    var start: Int = 0
    var end: Int = 0

    constructor(_start: Int, _end: Int) {
        start = _start
        end = _end
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Interval

        if (start != other.start) return false
        if (end != other.end) return false

        return true
    }

    override fun hashCode(): Int {
        var result = start
        result = 31 * result + end
        return result
    }

}


class Solution {

    fun employeeFreeTime(schedule: ArrayList<ArrayList<Interval>>): ArrayList<Interval> {
        val set = sortedSetOf<Pair<Int, Int>>(Comparator { o1, o2 ->
            if (o1.first == o2.first) {
                return@Comparator o1.second.compareTo(o2.second)
            }
            return@Comparator o1.first.compareTo(o2.first)
        })

        val map = hashMapOf<Int, Int>()

        for (intervals in schedule) {
            for (interval in intervals) {
                map[interval.start] = maxOf(map[interval.start] ?: 0, interval.end)
                set.add(Pair(interval.start, 1))
                set.add(Pair(interval.end, 0))
            }
        }
        val answers = ArrayList<Interval>()
        var lastStartTime = Int.MIN_VALUE
        var lastEndTime = Integer.MIN_VALUE
        var lastType = 0


        set.forEach { (nextTime, nextType) ->

            if (lastType == 0 && nextType == 1 && lastEndTime != Integer.MIN_VALUE && map[lastStartTime]!! < nextTime) {
                answers.add(Interval(lastEndTime, nextTime))
            }

            if (nextType == 1 && (lastStartTime == Integer.MIN_VALUE || map[lastStartTime]!! < map[nextTime]!!)) {
                lastStartTime = nextTime
            }

            if (nextType == 0) {
                lastEndTime = nextTime
            }

            lastType = nextType
        }

        return answers
    }
}

// [[7,24],[29,33],[45,57],[66,69],[94,99]]
// [[6,24],[43,49],[56,59],[61,75],[80,81]]
// [[5,16],[18,26],[33,36],[39,57],[65,74]]
// [[9,16],[27,35],[40,55],[68,71],[78,81]]
// [[0,25],[29,31],[40,47],[57,87],[91,94]]




