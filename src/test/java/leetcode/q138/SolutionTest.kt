package leetcode.q138

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("copyRandomList") {
        val node2 = Node(2).apply {
            this.random = this
            this.next = null
        }
        val node1 = Node(1).apply {
            this.random = node2
            this.next = node2
        }

        val result = Solution().copyRandomList(node1)
        println(result)
    }
})
