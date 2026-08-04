package leetcode.q138

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

class Solution {
    val map = mutableMapOf<Node, Node>()

    fun copyRandomList(node: Node?): Node? {

        if (node == null) {
            return null
        }

        if (map.containsKey(node)) {
            return map[node]!!
        }

        val copy = Node(node.`val`)
        map[node] = copy
        copy.next = copyRandomList(node.next)
        copy.random = copyRandomList(node.random)
        return copy
    }
}