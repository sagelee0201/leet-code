package com.leetcode.daily.copylistwithrandompointer;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void basicCase1() {
        //[[7,null],[13,0],[11,4],[10,2],[1,0]]
        final Node node0 = new Node(7);
        final Node node1 = new Node(13);
        final Node node2 = new Node(11);
        final Node node3 = new Node(10);
        final Node node4 = new Node(1);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node0.random = null;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;

        final Node copy = solution.copyRandomList(node0);

        assertTrue(equals(copy, node0));
    }

    @Test
    public void basicCase2() {
        //[[1,1],[2,1]]
        final Node node0 = new Node(1);
        final Node node1 = new Node(2);

        node0.next = node1;

        node0.random = node1;
        node1.random = node1;

        final Node copy = solution.copyRandomList(node0);

        assertTrue(equals(copy, node0));
    }

    @Test
    public void basicCase3() {
        //[[3,null],[3,0],[3,null]]
        final Node node0 = new Node(3);
        final Node node1 = new Node(3);
        final Node node2 = new Node(3);

        node0.next = node1;
        node1.next = node2;

        node0.random = null;
        node1.random = node0;
        node2.random = null;

        final Node copy = solution.copyRandomList(node0);

        assertTrue(equals(copy, node0));
    }

    @Test
    public void nullIsCopiedAsNull() {

        final Node copy = solution.copyRandomList(null);

        assertTrue(Objects.isNull(copy));
    }

    private boolean equals(Node headA, Node headB) {
        if (Objects.isNull(headA) && Objects.isNull(headB)) {
            return true;
        }

        final Map<Node, Integer> aNodeIndexMap = getNodeIndexMap(headA);
        final Map<Node, Integer> bNodeIndexMap = getNodeIndexMap(headB);
        final Map<Node, Node> nodeMap = getNodeMap(headA, headB);

        Node curA = headA;
        Node curB = headB;

        while (Objects.nonNull(curA)) {
            if (Objects.isNull(curB)) {
                return false;
            }

            if (!Objects.equals(aNodeIndexMap.get(curA),bNodeIndexMap.get(curB))) {
                return false;
            }

            if (!Objects.equals(nodeMap.get(curA.random), curB.random)) {
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
    private Map<Node, Integer> getNodeIndexMap(Node head) {
        final Map<Node, Integer> nodeMap = new HashMap<>();
        Node curNode = head;
        int index = 0;
        while (Objects.nonNull(curNode)) {
            nodeMap.put(curNode, index);
            index++;
            curNode = curNode.next;
        }
        return nodeMap;
    }

    private Map<Node, Node> getNodeMap(Node a, Node b) {
        final Map<Node, Node> nodeMap = new HashMap<>();
        Node curA = a;
        Node curB = b;
        while (Objects.nonNull(a)) {
            if (Objects.isNull(curB)) {
                return nodeMap;
            }
            nodeMap.put(curA, curB);
            curA = curA.next;
            curB = curB.next;
        }
        return nodeMap;
    }
}