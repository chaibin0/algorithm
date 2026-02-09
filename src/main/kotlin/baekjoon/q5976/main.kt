package baekjoon.q5976

fun main() {
    val n = readln().trim().toInt()

    val grids = Array(n) { IntArray(n) }
    val visit = Array(n) { BooleanArray(n) }

    val faces = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0)
    )
    var faceIndex = 0
    var i = 0
    var j = -1

    repeat(n * n) {

        i += faces[faceIndex][0]
        j += faces[faceIndex][1]

        visit[i][j] = true
        grids[i][j] = it + 1

        val nextI = i + faces[faceIndex][0]
        val nextJ = j + faces[faceIndex][1]
        if (nextI < 0 || nextJ < 0 || nextI >= n || nextJ >= n || visit[nextI][nextJ]) {
            faceIndex = (faceIndex + 1) % 4
        }
    }

    for (grid in grids) {
        println(grid.joinToString(" "))
    }
}