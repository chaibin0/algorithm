package leetcode.q814

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun pruneTree(root: TreeNode?): TreeNode? {

        if (root == null) {
            return null
        }

        if (dfs(root)) {
            return null
        }

        return root
    }

    fun dfs(head: TreeNode?): Boolean {

        if (head == null) {
            return true
        }

        var isHeadZero = false
        var isLeftAllZero = false
        var isRightAllZero = false

        if (head.`val` == 0) {
            isHeadZero = true
        }

        if (dfs(head.left)) {
            head.left = null
            isLeftAllZero = true
        }

        if (dfs(head.right)) {
            head.right = null
            isRightAllZero = true
        }

        return isHeadZero && isLeftAllZero && isRightAllZero
    }
}