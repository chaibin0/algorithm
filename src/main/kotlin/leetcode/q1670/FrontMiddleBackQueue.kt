package leetcode.q1670

class FrontMiddleBackQueue() {

    var left: ArrayDeque<Int> = ArrayDeque()
    var right: ArrayDeque<Int> = ArrayDeque()

    fun pushFront(`val`: Int) {

        left.addFirst(`val`)
        if (left.size >= right.size + 1) {
            right.addFirst(left.removeLast())
        }
    }


    fun pushMiddle(`val`: Int) {
        left.addLast(`val`)
        if (left.size >= right.size + 1) {
            right.addFirst(left.removeLast())
        }
    }

    fun pushBack(`val`: Int) {

        right.addLast(`val`)
        if (left.size + 2 <= right.size) {
            left.addLast(right.removeFirst())
        }
    }

    fun popFront(): Int {
        if (left.isEmpty() && right.isEmpty()) {
            return -1
        }


        val value = if (left.isNotEmpty()) {
            left.removeFirst()
        } else {
            right.removeFirst()
        }

        if (left.size + 2 <= right.size) {
            left.addLast(right.removeFirst())
        }

        return value
    }

    fun popMiddle(): Int {
        if (left.isEmpty() && right.isEmpty()) {
            return -1
        }

        val value = if (left.size < right.size) {
            right.removeFirst()
        } else {
            left.removeLast()
        }

        if (left.size + 2 <= right.size) {
            left.addLast(right.removeFirst())
        }

        return value
    }

    fun popBack(): Int {
        if (right.isEmpty() && left.isEmpty()) {
            return -1
        }

        val value =  if (right.isNotEmpty()) {
            right.removeLast()
        } else {
            left.removeLast()
        }

        if (left.size >= right.size + 1) {
            right.addFirst(left.removeLast())
        }

        return value
    }
}