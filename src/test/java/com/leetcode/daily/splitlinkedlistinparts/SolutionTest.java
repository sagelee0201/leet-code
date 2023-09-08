package com.leetcode.daily.splitlinkedlistinparts;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void basicCase0() {
        //[1,2,3], 5
        final ListNode head = makeList(new int[]{1, 2, 3});
        final int k = 5;


        final ListNode[] expected = {new ListNode(1), new ListNode(2), new ListNode(3), null, null};

        final ListNode[] listNodes = solution.splitListToParts(head, k);

        assertTrue(equals(listNodes, expected));
    }

    @Test
    public void basicCase1() {
        //[1,2,3,4,5,6,7,8,9,10], 3
        final ListNode head = makeList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        final int k = 3;

        final ListNode[] expected = {makeList(new int[]{1, 2, 3, 4}), makeList(new int[]{5, 6, 7}), makeList(new int[]{8, 9, 10})};

        final ListNode[] listNodes = solution.splitListToParts(head, k);

        assertTrue(equals(listNodes, expected));
    }

    @Test
    public void headIsNull() {
        //[], 3
        final ListNode head = null;
        final int k = 3;

        final ListNode[] expected = {null, null, null};

        final ListNode[] listNodes = solution.splitListToParts(head, k);

        assertTrue(equals(listNodes, expected));
    }

    private boolean equals(ListNode[] a, ListNode[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (!equals(a[i], b[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean equals(ListNode a, ListNode b) {
        ListNode curA = a;
        ListNode curB = b;

        while (Objects.nonNull(curA)) {
            if (Objects.isNull(curB)) {
                return false;
            }
            if (curA.val != curB.val) {
                return false;
            }
            curA = curA.next;
            curB = curB.next;
        }

        if (Objects.nonNull(curB)) {
            return false;
        }

        return true;
    }

    private ListNode makeList(int[] element) {
        final int length = element.length;

        if (length == 0) {
            return null;
        }

        final ListNode head = new ListNode(element[0]);
        ListNode cur = head;

        for(int i = 1; i < length; i++){
            final ListNode next = new ListNode();
            cur.next = next;
            cur = cur.next;
            cur.val = element[i];
        }

        return head;
    }
}