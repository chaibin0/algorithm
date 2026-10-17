package leetcode.q3433

import java.util.PriorityQueue

class Solution {

    private val offlineUserQueue = PriorityQueue<Pair<Int, Int>>(Comparator { a, b -> a.first - b.first })
    private val offlineUserSet = mutableSetOf<Int>()

    fun countMentions(numberOfUsers: Int, events: List<List<String>>): IntArray {
        val sortedEvents = events.sortedWith { event1, event2 ->
            if (event1[1].toInt() == event2[1].toInt()) {
                if (event1[0] == "MESSAGE" && event2[0] == "OFFLINE") {
                    return@sortedWith 1
                }
                if (event1[0] == "OFFLINE" && event2[0] == "MESSAGE") {
                    return@sortedWith -1
                }
                return@sortedWith 0
            }

            return@sortedWith event1[1].toInt().compareTo(event2[1].toInt())
        }

        val answers = IntArray(numberOfUsers)
        for (event in sortedEvents) {

            val message = event[0]
            val timestamp = event[1].toInt()
            val mention = event[2]

            while (offlineUserQueue.isNotEmpty()) {
                val (offlineTimestamp, lastOfflineUser) = offlineUserQueue.peek()
                if (timestamp < offlineTimestamp + 60) {
                    break
                }

                offlineUserSet.remove(lastOfflineUser)
                offlineUserQueue.poll()
            }

            when (message) {
                "MESSAGE" -> {
                    when (mention) {
                        "ALL" -> {
                            for (i in 0 until numberOfUsers) {
                                answers[i]++
                            }
                        }

                        "HERE" -> {
                            for (i in 0 until numberOfUsers) {
                                if (!offlineUserSet.contains(i)) {
                                    answers[i]++
                                }
                            }
                        }

                        else -> {
                            val ids = mention.split(" ")
                                .map { it.substring(2).toInt() }

                            for (id in ids) {
                                answers[id]++
                            }
                        }
                    }
                }

                "OFFLINE" -> {
                    offlineUserQueue.add(timestamp to mention.toInt())
                    offlineUserSet.add(mention.toInt())
                }
            }
        }

        return answers
    }
}