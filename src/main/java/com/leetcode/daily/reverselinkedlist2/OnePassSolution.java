package com.leetcode.daily.reverselinkedlist2;

import com.leetcode.common.datastructure.ListNode;

import java.util.Objects;

public class OnePassSolution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || Objects.isNull(head)) {
            return head;
        }
        if (Objects.isNull(head)) {
            return null;
        }

        final ListNode dummyHead = new ListNode(-1, head);
        //[1 (reverseStartPrev), 2 (reverseStart), 3, 4, 5 (reverseEnd), 6(reverseEndNext)], left = 2, right = 5
        ListNode reverseStartPrev = null;
        ListNode reverseStart = null;
        ListNode reverseEnd = null;
        ListNode reverseEndNext = null;

        ListNode cur = dummyHead;
        ListNode toBeNext = null;
        int idx = 0;

        while (Objects.nonNull(cur)) {
            if (idx == left - 1) {
                reverseStartPrev = cur;
            }
            if (idx == left) {
                reverseStart = cur;
            }
            if (idx == right) {
                reverseEnd = cur;
            }
            if (idx == right + 1) {
                reverseEndNext = cur;
                break;
            }
            final ListNode next = cur.next;
            if (idx >= left && idx <= right) {
                cur.next = toBeNext;
                toBeNext = cur;
            }
            cur = next;
            idx++;
        }
        reverseStartPrev.next = reverseEnd;
        reverseStart.next = reverseEndNext;

        return dummyHead.next;
    }
}
