package leetcode.q333

import kotlin.math.max


class Solution {

    private var answer = 1

    fun largestBSTSubtree(root: TreeNode?): Int {
        if(root == null) {
            return 0
        }
        subtree(root)
        return answer
    }

    private fun subtree(root: TreeNode?): Int {

        if (root == null) return 0
        val left: Int = if (root.left != null) {
            if (root.left!!.`val` < root.`val`) {
                subtree(root.left)
            } else {
                largestBSTSubtree(root.left)
                -1
            }
        } else {
            0
        }

        val right = if (root.right != null) {
            if (root.`val` < root.right!!.`val`) {
                subtree(root.right)
            } else {
                largestBSTSubtree(root.right)
                -1
            }
        } else {
            0
        }

        if (left == -1 || right == -1) {
            return -1
        }

        val result = left + right + 1
        answer = max(answer, result)
        return result
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
