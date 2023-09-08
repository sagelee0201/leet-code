package com.leetcode.common.util.linkedlist;

import com.leetcode.common.datastructure.ListNode;

import java.util.Objects;

public class LinkedListUtil {
    public static ListNode makeList(int[] element) {
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

    public static boolean equals(ListNode[] a, ListNode[] b) {
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

    public static boolean equals(ListNode a, ListNode b) {
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
}
