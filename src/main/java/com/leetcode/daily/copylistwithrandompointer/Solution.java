package com.leetcode.daily.copylistwithrandompointer;

import java.util.*;

public class Solution {
    public Node copyRandomList(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }
        final List<Node> copiedNode = copyNext(head);
        final Map<Node, Integer> nodeIndexMap = getNodeIndexMap(head);

        copyRandomList(copiedNode, nodeIndexMap, head);

        return copiedNode.get(0);
    }

    private List<Node> copyNext(Node head) {
        if (Objects.isNull(head)) {
            return Collections.emptyList();
        }
        final Node copiedHead = new Node(head.val);
        final List<Node> copiedList = new ArrayList<>();

        Node curCopied = copiedHead;
        copiedList.add(curCopied);
        Node cur = head.next;

        while (Objects.nonNull(cur)) {
            Node copied = new Node(cur.val);
            curCopied.next = copied;
            curCopied = curCopied.next;
            copiedList.add(curCopied);
            cur = cur.next;
        }

        return copiedList;
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

    private Node copyRandomList(List<Node> copiedNode, Map<Node, Integer> nodeIndexMap, Node originalHead) {
        Node cur = originalHead;

        while (Objects.nonNull(cur)) {
            final Integer idx = nodeIndexMap.get(cur);
            final Node copied = copiedNode.get(idx);
            if (Objects.nonNull(cur.random)) {
                copied.random = copiedNode.get(nodeIndexMap.get(cur.random));
            }
            cur = cur.next;
        }

        return copiedNode.get(0);
    }
}