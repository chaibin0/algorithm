package leetcode.problems.q82;

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
        if (Objects.isNull(head)) {
            return null;
        }

        ListNode output = null;
        ListNode outputPosition = output;
        ListNode position = head;
        int currentValue = -101;
        boolean isDuplicate = false;

        while (Objects.nonNull(position)) {
            if (position.val == currentValue) {
                isDuplicate = true;
                position = position.next;
                continue;
            }

            if (currentValue != -101 && !isDuplicate) {
                if (Objects.isNull(output)) {
                    output = new ListNode(currentValue);
                    outputPosition = output;
                } else {
                    outputPosition.next = new ListNode(currentValue);
                    outputPosition = outputPosition.next;
                }
            }

            isDuplicate = false;
            currentValue = position.val;
            position = position.next;
        }


        if (currentValue != -101 && !isDuplicate) {
            if (Objects.isNull(output)) {
                output = new ListNode(currentValue);
            } else {
                outputPosition.next = new ListNode(currentValue);
            }
        }


        return output;
    }
}