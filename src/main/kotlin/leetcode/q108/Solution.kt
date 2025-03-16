package leetcode.q108

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 *
 *
 *
 *
 */
class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return divide(0, nums.lastIndex, nums)
    }

    private fun divide(start: Int, end: Int, nums: IntArray): TreeNode? {

        if (start > end) {
            return null
        }

        val mid = (start + end) / 2
        val root = TreeNode(nums[mid])
        root.left = divide(start, mid - 1, nums)
        root.right = divide(mid + 1, end, nums)
        return root
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}