package leetcode.q2590

import java.util.*

class TodoList() {

    private val userIdToTask = mutableMapOf<Int, MutableMap<Int, Task>>()
    private val userIdToTag = mutableMapOf<Int, MutableMap<String, TreeSet<Task>>>()
    private val userIdToDueDate = mutableMapOf<Int, TreeMap<Int, Task>>()
    private var taskSequenceNumber = 1

    fun addTask(userId: Int, taskDescription: String, dueDate: Int, tags: List<String>): Int {
        val taskId = taskSequenceNumber
        val task = Task(taskId, taskDescription, dueDate, tags)
        if (!userIdToTask.containsKey(userId)) {
            userIdToTask[userId] = mutableMapOf()
        }

        userIdToTask[userId]!![taskId] = task

        if (!userIdToDueDate.containsKey(userId)) {
            userIdToDueDate[userId] = TreeMap<Int, Task>()
        }

        userIdToDueDate[userId]!![dueDate] = task

        if (!userIdToTag.containsKey(userId)) {
            userIdToTag[userId] = mutableMapOf()
        }

        for (tag in tags) {
            if (userIdToTag[userId]!![tag] == null) {
                userIdToTag[userId]!![tag] = TreeSet<Task>()
            }

            userIdToTag[userId]!![tag]!!.add(task)
        }
        taskSequenceNumber++
        return taskId
    }

    fun getAllTasks(userId: Int): List<String> {

        val taskMap = this.userIdToDueDate[userId] ?: return emptyList()
        val list = mutableListOf<String>()
        for (task in taskMap.values) {
            list.add(task.description)
        }

        return list
    }

    fun getTasksForTag(userId: Int, tag: String): List<String> {
        val taskSet = this.userIdToTag[userId]?.get(tag) ?: return emptyList()
        val list = mutableListOf<String>()
        for (task in taskSet) {
            list.add(task.description)
        }

        return list
    }

    fun completeTask(userId: Int, taskId: Int) {
        val task: Task = this.userIdToTask[userId]?.get(taskId) ?: return
        this.userIdToDueDate[userId]!!.remove(task.dueDate)

        for (tag in task.tags) {
            this.userIdToTag[userId]!!.get(tag)!!.remove(task)
        }

        this.userIdToTask[userId]!!.remove(taskId)
    }

    data class Task(
        val taskId: Int,
        val description: String,
        val dueDate: Int,
        val tags: List<String>
    ) : Comparable<Task> {

        override fun compareTo(other: Task): Int {
            return this.dueDate.compareTo(other.dueDate)
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Task

            return taskId == other.taskId
        }

        override fun hashCode(): Int {
            return taskId.hashCode()
        }
    }
}
