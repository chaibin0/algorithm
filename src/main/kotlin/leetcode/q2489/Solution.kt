package leetcode.q2489

class Solution {

    private var answer = 0L
    lateinit var s: String
    var num1: Int = 0
    var num2: Int = 0
    var sum: Int = 0
    var dp: MutableSet<Pair<Int, Int>> = mutableSetOf()

    fun fixedRatio(s: String, num1: Int, num2: Int): Long {
        this.s = s
        this.num1 = num1
        this.num2 = num2
        this.sum = num1 + num2

        var zero = 0
        var one = 0
        if (s[0] == '0') {
            zero++
        } else {
            one++
        }

        dfs(0, 0, zero, one)

        return answer
    }

    fun dfs(p: Int, q: Int, zero: Int, one: Int) {

        val c = Pair(p, q)


        if (dp.contains(c)) {
            return
        }


        // a : b = c : d
        // bc = ad
        if (zero > 0 && one > 0 &&
            (zero + one >= sum) &&
            ((zero + one) % sum == 0) &&
            (zero % num1 == 0) &&
            (one % num2 == 0) &&
            (one * num1 == zero * num2)
        ) {
            answer++
        }

        dp.add(c)

        if (q < s.lastIndex) {
            var nextZero = zero
            var nextOne = one
            if (s[q + 1] == '0') nextZero++ else nextOne++
            dfs(p, q + 1, nextZero, nextOne)
        }

        if (p < q) {
            var nextZero = zero
            var nextOne = one
            if (s[p] == '0') nextZero-- else nextOne--
            dfs(p + 1, q, nextZero, nextOne)
        }
    }
}