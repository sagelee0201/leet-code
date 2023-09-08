package com.leetcode.daily.stackusingqueues.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyStackTest {

    @Test
    public void push() {
        // given
        final MyStack myStack = new MyStack();
        int entityToPush = 10;

        // when
        myStack.push(entityToPush);

        // then
        Assertions.assertFalse(myStack.empty());
        Assertions.assertEquals(myStack.top(), entityToPush);
    }

    @Test
    public void multiplePushAndPop() {
        // given
        final MyStack myStack = new MyStack();
        int[] entitiesToPush = new int[]{1, 2, 3, 4};

        // when
        for (int entity: entitiesToPush) {
            myStack.push(entity);
        }

        // then
        for (int i = 0; i < entitiesToPush.length; i++) {
            final int popped = myStack.pop();
            Assertions.assertEquals(popped, entitiesToPush[entitiesToPush.length - i - 1]);
        }
    }

    @Test
    public void pop() {
        // given
        final MyStack myStack = new MyStack();
        int entityToPush = 10;
        myStack.push(entityToPush);

        // when
        int popped = myStack.pop();

        // then
        Assertions.assertEquals(popped, entityToPush);
    }

    @Test
    public void top() {
        // given
        final MyStack myStack = new MyStack();
        int entityToPush = 10;

        // when
        myStack.push(entityToPush);

        // then
        Assertions.assertFalse(myStack.empty());
        Assertions.assertEquals(myStack.top(), entityToPush);
    }

    @Test
    public void emptyTrue() {
        // given
        final MyStack myStack = new MyStack();

        // then
        Assertions.assertTrue(myStack.empty());
    }


    @Test
    public void emptyFalse() {
        // given
        final MyStack myStack = new MyStack();
        int entityToPush = 10;

        // when
        myStack.push(entityToPush);

        // then
        Assertions.assertFalse(myStack.empty());
    }
}