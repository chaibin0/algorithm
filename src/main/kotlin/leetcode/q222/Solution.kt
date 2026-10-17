package leetcode.q222

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0
        var answer = 1
        answer += countNodes(root.left)
        answer += countNodes(root.right)
        return answer
    }
}