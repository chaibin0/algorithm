package leetcode.q237

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun deleteNode(node: ListNode?) {

        if (node == null || node.next == null) {
            return
        }

        node.`val` = node.next!!.`val`
        if (node.next!!.next == null) {
            node.next = null
            return
        }
        deleteNode(node.next)
    }
}