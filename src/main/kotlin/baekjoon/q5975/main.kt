package baekjoon.q5975

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val paths = Array(n) { IntArray(n) }
    val visit = BooleanArray(n)
    val pathfinding = mutableListOf<MutableList<Int>>()
    val queue = ArrayDeque<Pair<Int, Int>>()
    for (i in 0 until n) {
        paths[i] = readln().split(' ').map { it.toInt() }.toIntArray()
    }

    pathfinding.add(mutableListOf(m))
    visit[m - 1] = true
    queue.addLast(Pair(m - 1, 1))

    while (queue.isNotEmpty()) {
        val (islands, hop) = queue.removeFirst()

        for ((nextIslands, value) in paths[islands].withIndex()) {
            if (value == 0 || (value == 1 && visit[nextIslands])) {
                continue
            }

            visit[nextIslands] = true
            queue.addLast(Pair(nextIslands, hop + 1))
            if (pathfinding.getOrNull(hop) == null) {
                pathfinding.add(mutableListOf(nextIslands + 1))
            } else {
                pathfinding[hop].add(nextIslands + 1)
            }
        }
    }

    pathfinding.forEach {
        it.sort()
        println(it.joinToString(" "))
    }
}