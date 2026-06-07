package leetcode.q1756

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MRUQueueTest : FunSpec({

    test("case1") {
        val queue = MRUQueue(8)
        queue.fetch(3) shouldBe 3
        queue.fetch(5) shouldBe 6
        queue.fetch(2) shouldBe 2
        queue.fetch(8) shouldBe 2
    }

    test("case2") {
        val queue = MRUQueue(3) // 1 2 3
        queue.fetch(2) shouldBe 2 // 1 3 2
        queue.fetch(1) shouldBe 1 // 3 2 1
        queue.fetch(2) shouldBe 2 // 3 1 2
        queue.fetch(2) shouldBe 1 // 3 2 1
        queue.fetch(2) shouldBe 2 // 3 1 2
        queue.fetch(3) shouldBe 2 // 3 1 2
        queue.fetch(2) shouldBe 1 // 3 2 1
        queue.fetch(1) shouldBe 3 // 2 1 3
        queue.fetch(1) shouldBe 2 // 1 3 2
        queue.fetch(2) shouldBe 3 // 1 2 3
    }
})
