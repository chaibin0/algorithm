package baekjoon.q5967


fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }

    val mat = Array(n) { IntArray(m) }
    val mark = Array(n) { BooleanArray(m) }

    repeat(n) { i ->
        val row = readln().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            mat[i][j] = row[j]
        }
    }

    var limy = -1
    var limx = -1

    fun swapRC(a: Int, b: Int, isCol: Boolean) {
        if (isCol) {
            for (i in 0 until n) {
                val tmp = mat[i][a]
                mat[i][a] = mat[i][b]
                mat[i][b] = tmp
            }
        } else {
            for (i in 0 until m) {
                val tmp = mat[a][i]
                mat[a][i] = mat[b][i]
                mat[b][i] = tmp
            }
        }
    }

    while (true) {
        var curMax = 0
        var y = -1
        var x = -1
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (!mark[i][j] && curMax < mat[i][j]) {
                    curMax = mat[i][j]
                    y = i
                    x = j
                }
            }
        }

        if (curMax == 0 || y == -1 || x == -1) break

        var yy = y
        while (yy > limy + 1) {
            swapRC(yy, yy - 1, isCol = false)
            yy--
        }

        var xx = x
        while (xx > limx + 1) {
            swapRC(xx, xx - 1, isCol = true)
            xx--
        }

        mark[yy][xx] = true
        if (limy < yy) limy = yy
        if (limx < xx) limx = xx
    }

    for (i in 0 until n) {
        println(mat[i].joinToString(" "))
    }
}
