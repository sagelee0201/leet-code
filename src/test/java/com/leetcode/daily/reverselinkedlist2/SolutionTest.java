package com.leetcode.daily.reverselinkedlist2;

import com.leetcode.common.datastructure.ListNode;
import com.leetcode.common.util.linkedlist.LinkedListUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void basicTestCase0() {
        //head = [1,2,3,4,5], left = 2, right = 4
        ListNode listNode = LinkedListUtil.makeList(new int[]{1, 2, 3, 4, 5});
        final int left = 2;
        final int right = 4;
        final ListNode expected = LinkedListUtil.makeList(new int[]{1, 4, 3, 2, 5});

        final ListNode result = solution.reverseBetween(listNode, left, right);

        assertTrue(LinkedListUtil.equals(result, expected));
    }

    @Test
    public void basicTestCase1() {
        //head = [5], left = 1, right = 1
        ListNode listNode = LinkedListUtil.makeList(new int[]{5});
        final int left = 1;
        final int right = 1;
        final ListNode expected = LinkedListUtil.makeList(new int[]{5});

        final ListNode result = solution.reverseBetween(listNode, left, right);

        assertTrue(LinkedListUtil.equals(result, expected));
    }

    @Test
    public void inputNull() {
        //head = [], left = 1, right = 1
        ListNode listNode = LinkedListUtil.makeList(new int[]{});
        final int left = 1;
        final int right = 1;
        final ListNode expected = LinkedListUtil.makeList(new int[]{});

        final ListNode result = solution.reverseBetween(listNode, left, right);

        assertTrue(LinkedListUtil.equals(result, expected));
    }

    @Test
    public void reverseEntireList() {
        //head = [1, 2, 3, 4, 5], left = 1, right = 5
        ListNode listNode = LinkedListUtil.makeList(new int[]{1, 2, 3, 4 ,5});
        final int left = 1;
        final int right = 5;
        final ListNode expected = LinkedListUtil.makeList(new int[]{5, 4, 3, 2, 1});

        final ListNode result = solution.reverseBetween(listNode, left, right);

        assertTrue(LinkedListUtil.equals(result, expected));
    }
}