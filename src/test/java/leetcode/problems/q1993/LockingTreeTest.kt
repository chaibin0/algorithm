package leetcode.problems.q1993

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LockingTreeTest : FunSpec({

    test("case1") {

        val tree = LockingTree(intArrayOf(-1, 0, 0, 1, 1, 2, 2))
        tree.lock(2, 2) shouldBe true
        tree.unlock(2, 3) shouldBe false
        tree.unlock(2, 2) shouldBe true
        tree.lock(4, 5) shouldBe true
        tree.upgrade(0, 1) shouldBe true
        tree.lock(0, 1) shouldBe false

    }
})
