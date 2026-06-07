package leetcode.q281

import io.kotest.assertions.print.print
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ZigzagIteratorTest : FunSpec({

    test("case1") {
        val v1 = intArrayOf(1, 2)
        val v2 = intArrayOf(3, 4, 5, 6)
        var i = ZigzagIterator(v1, v2)
        var ret = ArrayList<Int>()
        while (i.hasNext()) {
            ret.add(i.next())
        }

        ret shouldBe intArrayOf(1, 3, 2, 4, 5, 6)
    }

    test("case2") {
        val v1 = intArrayOf(1)
        val v2 = intArrayOf()
        var i = ZigzagIterator(v1, v2)
        var ret = ArrayList<Int>()
        while (i.hasNext()) {
            ret.add(i.next())
        }

        ret shouldBe intArrayOf(1)
    }

    test("case3") {
        val v1 = intArrayOf()
        val v2 = intArrayOf(1)
        var i = ZigzagIterator(v1, v2)
        var ret = ArrayList<Int>()
        while (i.hasNext()) {
            ret.add(i.next())
        }

        ret shouldBe intArrayOf(1)
    }
})
