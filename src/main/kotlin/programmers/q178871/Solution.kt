package programmers.q178871

class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        val playersMap: MutableMap<String, Player> = mutableMapOf()

        val head: Player = Player("head")
        var position: Player = head

        for (player in players) {
            val p = Player(player)
            position.next = p
            p.previous = position
            position = p
            playersMap[player] = p
        }

        for (calling in callings) {
            val currentPlayer = playersMap[calling]
            val temp = currentPlayer!!.previous!!.name
            currentPlayer!!.previous!!.name = currentPlayer.name
            playersMap[currentPlayer.name] = currentPlayer!!.previous!!
            currentPlayer.name = temp
            playersMap[temp] = currentPlayer
        }

        position = head
        while (position.next != null) {
            position = position.next!!
            answer.add(position.name)
        }

        return answer.toTypedArray()
    }

    class Player(var name: String) {
        var next: Player? = null
        var previous: Player? = null
    }
}