package leetcode.problems.mergeTwoSortedLists;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode iter = head;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                iter.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                iter.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            iter = iter.next;
        }

        while (l1 != null) {
            iter.next = new ListNode(l1.val);
            l1 = l1.next;
            iter = iter.next;
        }

        while (l2 != null) {
            iter.next = new ListNode(l2.val);
            l2 = l2.next;
            iter = iter.next;
        }

        return head.next;
    }
}