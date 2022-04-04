package leetcode.problems.q61;


import java.util.Objects;

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
    public ListNode rotateRight(ListNode head, int k) {

        if (Objects.isNull(head)) {
            return null;
        }

        int headSize = size(head);

        if (headSize == 1) {
            return head;
        }

        int boundaryIndex = k % headSize;

        if (boundaryIndex == 0) {
            return head;
        }

        ListNode position = head;
        ListNode front;
        ListNode behind = null;

        if (boundaryIndex != 0) {
            behind = head;
        }

        for (int i = 0; i < headSize - boundaryIndex - 1; i++) {
            position = position.next;
        }

        front = position.next;
        position.next = null;
        position = front;

        for (int i = 0; i < boundaryIndex - 1; i++) {
            position = position.next;
        }

        position.next = behind;
        return front;
    }

    public int size(ListNode head) {

        if (Objects.isNull(head)) {
            return 0;
        }

        int count = 1;
        while (head.next != null) {
            count++;
            head = head.next;
        }

        return count;
    }
}