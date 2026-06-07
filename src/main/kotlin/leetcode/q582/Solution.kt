package leetcode.q582

class Solution {
    fun killProcess(pid: List<Int>, ppid: List<Int>, kill: Int): List<Int> {

        val answers = mutableListOf<Int>()
        val map = hashMapOf<Int, MutableList<Int>>()
        for (i in 0 until pid.size) {
            val parent = ppid[i]
            val child = pid[i]
            map.getOrPut(parent) { mutableListOf() }.add(child)
        }

        val queue = ArrayDeque<Int>()

        queue.add(kill)
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            answers.add(current)
            map[current]?.let {
                it.forEach { child ->
                    queue.add(child)
                }
            } ?: continue
        }

        return answers
    }
}