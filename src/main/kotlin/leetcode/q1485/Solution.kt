package leetcode.q1485

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var random: Node? = null
}

class NodeCopy(var `val`: Int) {
    var left: NodeCopy? = null
    var right: NodeCopy? = null
    var random: NodeCopy? = null
}

class Solution {

    val map = mutableMapOf<Node, NodeCopy>()
    fun copyRandomBinaryTree(root: Node?): NodeCopy? {

        if (root == null) return null
        if (map.containsKey(root)) {
            return map[root]
        }
        val copy = NodeCopy(root.`val`)
        map[root] = copy
        copy.random = copyRandomBinaryTree(root.random)
        copy.left = copyRandomBinaryTree(root.left)
        copy.right = copyRandomBinaryTree(root.right)
        return copy
    }
}