package leetcode.q841

class Solution {

    private lateinit var visit: BooleanArray

    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        visit = BooleanArray(rooms.size)
        dfs(0, rooms)

        for (value in visit) {
            if (!value) {
                return false
            }
        }

        return true
    }

    private fun dfs(currentRoom: Int, rooms: List<List<Int>>) {

        if (visit[currentRoom]) {
            return
        }

        visit[currentRoom] = true

        for (key in rooms[currentRoom]) {
            if (visit[key]) {
                continue
            }

            dfs(key, rooms)
        }
    }
}