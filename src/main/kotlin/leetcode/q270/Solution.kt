package leetcode.q270

import kotlin.math.abs
import kotlin.math.min

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun closestValue(root: TreeNode?, target: Double): Int {
        var result = root!!.`val`
        var current = if (root.`val` < target) {
            root.right
        } else {
            root.left
        }

        while (current != null) {
            val value = current.`val`.toDouble()

            if (value == target) {
                return current.`val`
            }

            if (abs(target - value) < abs(target - result)) {
                result = current.`val`
            }

            if (abs(target - value) == abs(target - result)) {
                result = min(result, current.`val`)
            }


            current = if (current.`val` < target) {
                current.right
            } else {
                current.left
            }
        }

        return result
    }
}
