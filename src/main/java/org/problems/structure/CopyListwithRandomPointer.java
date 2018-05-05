package org.problems.structure;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/copy-list-with-random-pointer/description/
public class CopyListwithRandomPointer {

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode node = head;
        RandomListNode newNode = newHead;
        while (node != null) {
            newNode.next = new RandomListNode(node.label);
            map.put(node, newNode.next);
            node = node.next;
            newNode = newNode.next;
        }

        node = head;
        newNode = newHead.next;
        while (node != null) {
            if (node.random != null) {
                newNode.random = map.get(node.random);
            }
            node = node.next;
            newNode = newNode.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        RandomListNode l1 = new RandomListNode(1);
        RandomListNode l2 = new RandomListNode(2);
        l2.random = l1;
        l1.next = l2;
        RandomListNode newHead = copyRandomList(l1);
        System.out.println();
    }
}
