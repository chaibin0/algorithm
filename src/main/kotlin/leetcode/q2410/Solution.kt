package leetcode.q2410

class Solution {
    fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
        players.sortDescending()
        trainers.sortDescending()

        var answer = 0
        var playerIndex = 0
        var trainerIndex = 0

        while (playerIndex < players.size && trainerIndex < trainers.size) {

            if (players[playerIndex] <= trainers[trainerIndex]) {
                trainerIndex++
                answer++
            }
            playerIndex++
        }

        return answer
    }
}