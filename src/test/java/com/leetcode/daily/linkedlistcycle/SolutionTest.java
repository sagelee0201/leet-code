package com.leetcode.daily.linkedlistcycle;

import com.leetcode.common.annotation.FailedTestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void returnTrueWhenThereIsACycle0() {
        final ListNode listNode0 = new ListNode(0);
        final ListNode listNode1 = new ListNode(1);
        final ListNode listNode2 = new ListNode(2);
        final ListNode listNode3 = new ListNode(3);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode0;

        final boolean hasCycle = solution.hasCycle(listNode0);

        assertTrue(hasCycle);
    }

    @Test
    public void returnTrueWhenThereIsACycle1() {
        final ListNode listNode0 = new ListNode(0);
        listNode0.next = listNode0;

        final boolean hasCycle = solution.hasCycle(listNode0);

        assertTrue(hasCycle);
    }

    @Test
    public void returnTrueWhenThereIsACycle2() {
        final ListNode listNode0 = new ListNode(0);
        final ListNode listNode1 = new ListNode(1);
        final ListNode listNode2 = new ListNode(2);
        final ListNode listNode3 = new ListNode(3);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode1;

        final boolean hasCycle = solution.hasCycle(listNode0);

        assertTrue(hasCycle);
    }

    @Test
    public void returnFalseWhenThereIsACycle() {
        final ListNode listNode0 = new ListNode(0);
        final ListNode listNode1 = new ListNode(1);
        final ListNode listNode2 = new ListNode(2);
        final ListNode listNode3 = new ListNode(3);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        final boolean hasCycle = solution.hasCycle(listNode0);

        assertFalse(hasCycle);
    }

    @Test
    @FailedTestCase
    public void returnFalseWhenHeadIsNull() {
        final ListNode nullNode = null;

        final boolean hasCycle = solution.hasCycle(nullNode);

        assertFalse(hasCycle);
    }

}