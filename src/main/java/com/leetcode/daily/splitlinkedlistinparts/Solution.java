package com.leetcode.daily.splitlinkedlistinparts;

import java.util.Objects;

public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        final int length = getLength(head);
        final int[] splitLength = getSplitLength(length, k);
        final ListNode[] splitParts = new ListNode[k];

        ListNode curHead = head;
        for (int i = 0; i < k; i++) {
            final ListNode nextHead = splitFirstNNodes(curHead, splitLength[i]);
            splitParts[i] = curHead;
            curHead = nextHead;
        }

        return splitParts;
    }

    private int getLength(ListNode head) {
        ListNode cur = head;
        int length = 0;
        while (Objects.nonNull(cur)) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    private int[] getSplitLength(int totalLength, int k) {
        int quotient = totalLength / k;
        int remainder = totalLength % k;
        final int[] splitLength = new int[k];

        for (int i = 0; i < remainder; i++) {
            splitLength[i] = quotient + 1;
        }

        for (int i = remainder; i < k; i++) {
            splitLength[i] = quotient;
        }

        return splitLength;
    }

    private ListNode splitFirstNNodes(ListNode head, int n) {
        ListNode cur = head;
        for (int i = 0; i < n - 1; i++) {
            if (Objects.isNull(cur)) {
                throw new RuntimeException("cannot split first " + n + " nodes: " + i+ "th element is null");
            }
            cur = cur.next;
        }

        if (Objects.isNull(cur)) {
            return null;
        }
        final ListNode nextHead = cur.next;
        cur.next = null;

        return nextHead;
    }
}
