package baekjoon.q5947

fun main() {
    val (N, NQ, P) = readln().split(" ").map { it.toInt() }
    val arr = Array(N) {
        IntArray(NQ) { 0 }
    }

    for (i in 0 until N) {
        arr[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    val qnaList = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until P) {
        val (Qj, Aj) = readln().split(" ").map { it.toInt() }
        qnaList.add(Qj to Aj)
    }
    var answer = 0
    for ((index, id) in arr.withIndex()) {
        var isAllCorrect = true
        for ((Qj, Aj) in qnaList) {
            if (id[Qj - 1] != Aj) {
                isAllCorrect = false
                break
            }
        }

        if (isAllCorrect) {
            answer++
        }
    }

    println(answer)
}