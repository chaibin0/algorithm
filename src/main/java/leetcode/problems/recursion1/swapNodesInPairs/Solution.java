package leetcode.problems.recursion1.swapNodesInPairs;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        helper(head);
        return head;
    }

    public ListNode helper(ListNode item) {

        if (item == null || item.next == null) {
            return item;
        }
        ListNode temp1 = item.next;
        ListNode temp2 = item.next.next;
        temp1.next = item;
        item = temp2;

        helper(temp2);
        return temp1;
    }
}