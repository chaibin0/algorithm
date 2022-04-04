package leetcode.problems.removeNthNodeFromEndofList;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = getLengthListNode(head);
        ListNode iter = removeListNode(head, length - n);
        return iter;
    }

    int getLengthListNode(ListNode head) {

        int length = 1;
        ListNode iter = head;
        while (iter.next != null) {
            length++;
            iter = iter.next;
        }

        return length;
    }

    ListNode removeListNode(ListNode head, int index) {

        ListNode iter = head;

        if (index == 0) {
            return iter.next;
        }

        while (index > 1) {
            iter = iter.next;
            index--;
        }
        ListNode temp = iter.next;
        if (iter.next.next != null) {
            iter.next = iter.next.next;
            temp = null;
        } else {
            iter.next = null;
        }
        return head;
    }
}
