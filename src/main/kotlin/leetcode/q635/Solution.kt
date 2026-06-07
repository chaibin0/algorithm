package leetcode.q635

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class LogSystem() {

    val map = sortedMapOf<LocalDateTime, MutableList<Int>>()

    fun put(id: Int, timestamp: String) {
        val datetime = convertLocalDateTime(timestamp)
        map.computeIfAbsent(datetime) { mutableListOf() }.add(id)
    }

    fun retrieve(start: String, end: String, granularity: String): List<Int> {

        val startDateTime = truncatedTo(convertLocalDateTime(start), granularity)
        val endDateTime = truncatedTo(convertLocalDateTime(end), granularity)
        val answers = mutableListOf<Int>()
        val next = map.tailMap(startDateTime)

        for ((datetime, list) in next.entries) {
            val currentDateTime = truncatedTo(datetime, granularity)
            if (startDateTime.isAfter(currentDateTime) || endDateTime.isBefore(currentDateTime)) {
                break
            }

            list.forEach {
                answers.add(it)
            }
        }

        return answers
    }

    fun truncatedTo(date: LocalDateTime, granularity: String): LocalDateTime {
        return when (granularity) {
            "Year" -> LocalDateTime.of(date.year, 1, 1, 0, 0, 0)
            "Month" -> LocalDateTime.of(date.year, date.month, 1, 0, 0, 0)
            "Day" -> date.truncatedTo(ChronoUnit.DAYS)
            "Hour" -> date.truncatedTo(ChronoUnit.HOURS)
            "Minute" -> date.truncatedTo(ChronoUnit.MINUTES)
            else -> date.truncatedTo(ChronoUnit.SECONDS)
        }
    }

    fun convertLocalDateTime(timestamp: String): LocalDateTime {
        return timestamp.split(":").let {
            LocalDateTime.of(
                it[0].toInt(),
                it[1].toInt(),
                it[2].toInt(),
                it[3].toInt(),
                it[4].toInt(),
                it[5].toInt()
            )
        }
    }
}
