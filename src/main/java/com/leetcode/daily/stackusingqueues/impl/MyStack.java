// Date: 2023.08.28
// No: 225
package com.leetcode.daily.stackusingqueues.impl;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public MyStack() {

    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        prepareForPopAndTop();
        final Integer polled = q1.poll();
        swapQueues();
        return polled;
    }

    public int top() {
        prepareForPopAndTop();
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    private void swapQueues() {
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    private void prepareForPopAndTop() {
        while (q1.size() > 1) {
            final Integer polled = q1.poll();
            q2.add(polled);
        }
    }
}
