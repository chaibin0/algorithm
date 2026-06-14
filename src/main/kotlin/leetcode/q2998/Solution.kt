package leetcode.q2998

class Solution {
    fun minimumOperationsToMakeEqual(x: Int, y: Int): Int {

        if (x == y) {
            return 0
        }

        val visitedValue = mutableSetOf<Int>()
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(x to 0)
        while (queue.isNotEmpty()) {
            val (currentX, step) = queue.removeFirst()

            if (currentX % 11 == 0) {
                val nextValue = currentX / 11
                if (nextValue == y) {
                    return step + 1
                }
                if (!visitedValue.contains(nextValue)) {
                    visitedValue.add(nextValue)
                    queue.add(nextValue to (step + 1))
                }
            }

            if (currentX % 5 == 0) {
                val nextValue = currentX / 5
                if (nextValue == y) {
                    return step + 1
                }
                if (!visitedValue.contains(nextValue)) {
                    visitedValue.add(nextValue)
                    queue.add(nextValue to (step + 1))
                }
            }

            if (!visitedValue.contains(currentX + 1)) {
                if (currentX + 1 == y) {
                    return step + 1
                }
                visitedValue.add(currentX + 1)
                queue.add((currentX + 1) to (step + 1))
            }

            if (!visitedValue.contains(currentX - 1)) {
                if (currentX - 1 == y) {
                    return step + 1
                }
                visitedValue.add(currentX - 1)
                queue.add((currentX - 1) to (step + 1))
            }
        }

        return 0
    }
}