package com.leetcode.daily.linkedlistcycle;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (Objects.isNull(head)) {
            return false;
        }

        final Set<ListNode> nodeSet = new HashSet<>();
        ListNode cur = head;

        while (Objects.nonNull(cur.next)) {
            if (nodeSet.contains(cur)) {
                return true;
            }
            nodeSet.add(cur);
            cur = cur.next;
        }

        return false;
    }
}
