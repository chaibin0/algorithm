package problems.q86;

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
    public ListNode partition(ListNode head, int x) {
        if (Objects.isNull(head)) {
            return null;
        }

        ListNode position = head;
        ListNode leftNode = null;
        ListNode leftNextNode = null;
        ListNode rightNode = null;
        ListNode rightNextNode = null;


        while (Objects.nonNull(position)) {
            if (position.val < x) {
                if (Objects.isNull(leftNode)) {
                    leftNode = new ListNode(position.val);
                    leftNextNode = leftNode;
                    position = position.next;
                    continue;
                }
                leftNextNode.next = new ListNode(position.val);
                leftNextNode = leftNextNode.next;
            } else {
                if (Objects.isNull(rightNode)) {
                    rightNode = new ListNode(position.val);
                    rightNextNode = rightNode;
                    position = position.next;
                    continue;
                }
                rightNextNode.next = new ListNode(position.val);
                rightNextNode = rightNextNode.next;
            }

            position = position.next;
        }

        if (Objects.nonNull(leftNextNode)) {
            leftNextNode.next = rightNode;
        }
        return Objects.nonNull(leftNode) ? leftNode : rightNode;
    }
}