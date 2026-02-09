package baekjoon.q33062

private fun buildA(p: Int): Long {
    // A[p] = "444...45" (length p)
    // p>=2
    var x = 0L
    for (i in 1 until p) { // p-1 times '4'
        x = x * 10 + 4
    }
    x = x * 10 + 5
    return x
}

fun main() {
    val t = readln().trim().toInt()

    // Precompute ranges for p = 2..10 (N <= 1e9, but safe up to 10)
    val maxP = 10
    val A = LongArray(maxP + 1)
    val B = LongArray(maxP + 1)
    var pow10 = 1L

    for (p in 1..maxP) {
        pow10 *= 10L // pow10 = 10^p
        if (p >= 2) {
            A[p] = buildA(p)
            // B[p] = 499..99 = 5*10^(p-1) - 1
            val tenPminus1 = pow10 / 10L
            B[p] = 5L * tenPminus1 - 1L
        }
    }

    repeat(t) {
        val n = readln().trim().toLong()
        var ans = 0L
        for (p in 2..maxP) {
            val a = A[p]
            val b = B[p]
            if (n < a) continue
            val hi = minOf(n, b)
            if (hi >= a) ans += (hi - a + 1)
        }
        print(ans)
    }
}
