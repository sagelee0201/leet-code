package com.leetcode.daily.stackusingqueues.additional_impl;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackAdditional {
    private final Queue<Integer> queue;

    public MyStackAdditional() {
        queue = new LinkedList<>();
    }
    public void push(int x) {
        queue.add(x);
        final int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
