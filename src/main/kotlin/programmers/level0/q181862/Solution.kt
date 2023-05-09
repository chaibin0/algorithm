package programmers.level0.q181862

class Solution {
    fun solution(myStr: String): Array<String> {

        var list = mutableListOf<String>()

        var sb = StringBuilder()
        for (c in myStr) {
            if (c == 'a' || c == 'b' || c == 'c') {
                if (sb.isNotEmpty()) {
                    list.add(sb.toString())
                    sb.clear()
                }
                continue
            }

            sb.append(c)
        }

        if (sb.isNotEmpty()) {
            list.add(sb.toString())
            sb.clear()
        }

        if (list.isEmpty()) {
            list.add("EMPTY")
        }
        return list.toTypedArray()
    }
}