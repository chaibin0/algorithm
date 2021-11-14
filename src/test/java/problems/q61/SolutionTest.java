package problems.q61;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void rotateRight() {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        new Solution().rotateRight(listNode1, 2);
    }

    @Test
    void rotateRight2() {
        ListNode listNode = new ListNode(1);

        new Solution().rotateRight(listNode, 1);
    }

    @Test
    void rotateRight3() {
        ListNode listNode2 = new ListNode(2);
        ListNode listNode = new ListNode(1, listNode2);

        new Solution().rotateRight(listNode, 1);
    }
}