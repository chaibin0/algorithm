package leetcode.q723

class Solution {

    fun candyCrush(board: Array<IntArray>): Array<IntArray> {

        var isClear = false
        val m = board.size
        val n = board[0].size
        while (!isClear) {
            isClear = true
            val isVerticalCandy = mutableSetOf<Pair<Int, Int>>()
            val isHorizontalCandy = mutableSetOf<Pair<Int, Int>>()

            //find
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (board[i][j] == 0) {
                        continue
                    }

                    val currIndex = Pair(i, j)
                    val currentValue = board[i][j]

                    if (!isHorizontalCandy.contains(currIndex)) {
                        var count = 1
                        val visited = mutableSetOf<Pair<Int, Int>>()
                        visited.add(currIndex)
                        for (currentX in (j + 1) until n) {
                            if (board[i][currentX] != currentValue) {
                                break
                            }

                            count++
                            visited.add(Pair(i, currentX))
                        }

                        if (count >= 3) {
                            isClear = false
                            isHorizontalCandy.addAll(visited)
                        }
                    }

                    if (!isVerticalCandy.contains(currIndex)) {
                        var count = 1
                        val visited = mutableSetOf<Pair<Int, Int>>()
                        visited.add(currIndex)
                        for (currentY in (i + 1) until m) {
                            if (board[currentY][j] != currentValue) {
                                break
                            }
                            count++
                            visited.add(Pair(currentY, j))
                        }

                        if (count >= 3) {
                            isClear = false
                            isVerticalCandy.addAll(visited)
                        }
                    }
                }
            }
            if (isClear) {
                break
            }

            //remove
            for (j in 0 until n) {
                var count = 0
                for (remainIndex in m - 1 downTo 0) {
                    if (board[remainIndex][j] == 0) {
                        break
                    }

                    val curr = Pair(remainIndex, j)
                    if (isVerticalCandy.contains(curr) || isHorizontalCandy.contains(curr)) {
                        count++
                        board[remainIndex][j] = 0
                        continue
                    }
                    if (count >= 1) {
                        board[remainIndex + count][j] = board[remainIndex][j]
                        board[remainIndex][j] = 0
                    }
                }
            }
        }

        return board
    }
}