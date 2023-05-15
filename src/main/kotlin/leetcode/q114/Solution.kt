package leetcode.q114

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    private lateinit var list: MutableList<TreeNode>

    fun flatten(root: TreeNode?): Unit {

        if (root == null) {
            return
        }

        list = mutableListOf()

        preOrder(root)
        var head: TreeNode = root

        for (node in list) {
            if (node == root) {
                continue
            }

            head.right = node
            head.left = null
            head = node
        }
    }

    private fun preOrder(head: TreeNode?) {

        if (head == null) {
            return
        }

        list.add(head)
        preOrder(head.left)
        preOrder(head.right)
    }
}