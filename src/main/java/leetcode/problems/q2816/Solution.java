package leetcode.problems.q2816;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode doubleIt(ListNode head) {

        ListNode position = head;

        while (position != null) {
            position.val = position.val * 2;
            position = position.next;
        }

        position = head;

        if (head.val >= 10) {
            ListNode one = new ListNode(1);
            one.next = head;
            head = one;
        }

        while (position != null) {

            int value = position.val;
            if (position.next != null) {
                value += (position.next.val / 10);
            }

            position.val = value % 10;
            position = position.next;
        }

        return head;
    }
}
