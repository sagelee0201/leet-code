package com.leetcode.daily.reverselinkedlist2;

import com.leetcode.common.datastructure.ListNode;

import java.util.*;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || Objects.isNull(head)) {
            return head;
        }
        if (Objects.isNull(head)) {
            return null;
        }

        final Map<Integer, ListNode> map = convertIntoMap(head);
        reverseBetween(map, left, right);

        return convertIntoLinkedList(map);
    }

    private Map<Integer, ListNode> convertIntoMap(ListNode head) {
        final Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;
        int idx = 0;
        while (Objects.nonNull(cur)) {
            map.put(idx, cur);
            cur = cur.next;
            idx++;
        }
        return map;
    }

    private ListNode convertIntoLinkedList(Map<Integer, ListNode> map) {
        final int size = map.size();
        for (int i = 1; i < size; i++) {
            final ListNode ithNode = map.get(i);
            map.get(i - 1).next = ithNode;
            ithNode.next = null;
        }
        return map.get(0);
    }

    private void reverseBetween(Map<Integer, ListNode> map, int left, int right) {
        for (int i = 0; i < (right - left + 1) / 2; i++) {
            ListNode a = map.get(i + left - 1);
            ListNode b = map.get(right - i - 1);
            map.put(right - i - 1, a);
            map.put(i + left - 1, b);
        }
    }
}
