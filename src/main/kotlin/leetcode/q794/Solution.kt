package leetcode.q794

class Solution {

    fun validTicTacToe(board: Array<String>): Boolean {

        var xTotalCount = 0
        var oTotalCount = 0

        for (row in board) {
            for (c in row) {
                if (c == 'O') {
                    oTotalCount++
                }
                if (c == 'X') {
                    xTotalCount++
                }
            }
        }

        if (xTotalCount < oTotalCount) {
            return false
        }

        if (xTotalCount > oTotalCount + 1) {
            return false
        }

        val (p1, p2) = isTicTacToc(board)

        if (p1 >= 1 && p2 >= 1) {
            return false
        }

        if (p1 >= 1 && xTotalCount <= oTotalCount) {
            return false
        }

        if (p2 >= 1 && xTotalCount != oTotalCount) {
            return false
        }

        return true
    }

    private fun isTicTacToc(board: Array<String>): Pair<Int, Int> {

        var p1 = 0
        var p2 = 0

        rowTicTacToc(board).run {
            val (r1, r2) = this
            p1 += r1
            p2 += r2
        }

        columnTicTacToc(board).run {
            val (r1, r2) = this
            p1 += r1
            p2 += r2
        }

        leftDiagonalTicTacToc(board).run {
            val (r1, r2) = this
            p1 += r1
            p2 += r2
        }

        rightDiagonalTicTacToc(board).run {
            val (r1, r2) = this
            p1 += r1
            p2 += r2
        }

        return p1 to p2
    }

    private fun rightDiagonalTicTacToc(board: Array<String>): Pair<Int, Int> {
        var xCount = 0
        var oCount = 0

        val diagonal = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(1, 1),
            intArrayOf(2, 0)
        )
        for ((row, column) in diagonal) {
            if (board[row][column] == 'O') {
                oCount++
            }
            if (board[row][column] == 'X') {
                xCount++
            }
        }

        if (xCount == 3) {
            return 1 to 0
        }

        if (oCount == 3) {
            return 0 to 1
        }

        return 0 to 0
    }

    private fun leftDiagonalTicTacToc(board: Array<String>): Pair<Int, Int> {
        var xCount = 0
        var oCount = 0

        val diagonal = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
            intArrayOf(2, 2)
        )
        for ((row, column) in diagonal) {
            if (board[row][column] == 'O') {
                oCount++
            }
            if (board[row][column] == 'X') {
                xCount++
            }
        }

        if (xCount == 3) {
            return 1 to 0
        }

        if (oCount == 3) {
            return 0 to 1
        }

        return 0 to 0
    }

    private fun rowTicTacToc(board: Array<String>): Pair<Int, Int> {

        var firstTicTacToc = 0
        var SecondTicTacToc = 0

        for (row in 0 until 3) {
            var xCount = 0
            var oCount = 0

            for (column in 0 until 3) {
                if (board[row][column] == 'O') {
                    oCount++
                }
                if (board[row][column] == 'X') {
                    xCount++
                }
            }

            if (xCount == 3) {
                firstTicTacToc++
            }

            if (oCount == 3) {
                SecondTicTacToc++
            }
        }

        return firstTicTacToc to SecondTicTacToc
    }

    private fun columnTicTacToc(board: Array<String>): Pair<Int, Int> {

        var firstTicTacToc = 0
        var SecondTicTacToc = 0

        for (column in 0 until 3) {
            var xCount = 0
            var oCount = 0

            for (row in 0 until 3) {
                if (board[row][column] == 'O') {
                    oCount++
                }
                if (board[row][column] == 'X') {
                    xCount++
                }
            }

            if (xCount == 3) {
                firstTicTacToc++
            }

            if (oCount == 3) {
                SecondTicTacToc++
            }
        }

        return firstTicTacToc to SecondTicTacToc
    }
}