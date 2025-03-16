package leetcode.q1670

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FrontMiddleBackQueueTest : FunSpec({

    test("case1") {
        val q = FrontMiddleBackQueue()
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        q.popFront();     // return 1 -> [4, 3, 2]
        q.popMiddle();    // return 3 -> [4, 2]
        q.popMiddle();    // return 4 -> [2]
        q.popBack();      // return 2 -> []
        q.popFront();     // return -1 -> [] (The queue is empty)

        println()
    }

    test("case2") {
        val q = FrontMiddleBackQueue()
        q.pushMiddle(1);    // [1, 2]
        q.pushMiddle(2);  // [1, 3, 2]
        q.pushMiddle(3);  // [1, 4, 3, 2]
        q.popMiddle();     // return 1 -> [4, 3, 2]
        q.popMiddle();    // return 3 -> [4, 2]
        q.popMiddle();    // return 4 -> [2]
        println()
    }
})
