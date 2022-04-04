package leetcode.problems.q83;

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
    public ListNode deleteDuplicates(ListNode head) {

        if(Objects.isNull(head)){
            return null;
        }

        int currentValue = head.val;
        ListNode lastPosition = head;
        ListNode position = head.next;
        while (Objects.nonNull(position)) {
            if (position.val == lastPosition.val) {
                lastPosition.next = position.next;
                position = position.next;
                continue;
            }

            currentValue = position.val;
            lastPosition = position;
            position = position.next;
        }

        return head;
    }
}