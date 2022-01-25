package problems.q83;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void deleteDuplicates1() {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        new Solution().deleteDuplicates(listNode1);
    }

    @Test
    void deleteDuplicates2() {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;



        new Solution().deleteDuplicates(listNode1);
    }
}