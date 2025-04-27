package leetcode.q563

import kotlin.math.abs

class Solution {

    private var answer = 0

    fun findTilt(root: TreeNode?): Int {
        traverse(root)
        return answer
    }

    private fun traverse(root: TreeNode?): Int {
        if (root == null) return 0

        val left = if (root.left != null) {
            traverse(root.left)
        } else {
            0
        }

        val right = if (root.right != null) {
            traverse(root.right)
        } else {
            0
        }

        answer += abs(left - right)
        return root.`val` + left + right
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}