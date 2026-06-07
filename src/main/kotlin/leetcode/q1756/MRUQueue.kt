package leetcode.q1756

class MRUQueue {
    var head: TreeNode = TreeNode()
    var tail: TreeNode

    constructor(n: Int) {
        var current = head
        for (i in 1..n) {
            current.next = TreeNode(i)
            current.next!!.previous = current
            current = current.next!!
        }

        tail = current
    }

    fun fetch(k: Int): Int {
        var current = head
        repeat(k) {
            current = current.next!!
        }

        if (current == tail) {
            return current.`val`!!
        }
        mutableListOf<Int>().remove(3)

        val previous = current.previous
        val next = current.next
        previous?.next = next
        next?.previous = previous
        tail.next = current
        current.previous = tail
        tail = current
        return current.`val`!!
    }
}

class TreeNode(
    var `val`: Int? = null,
    var previous: TreeNode? = null,
    var next: TreeNode? = null
)