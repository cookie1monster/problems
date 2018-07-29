package org.problems.lists;

import org.problems.structure.ListNode;

//https://leetcode.com/problems/middle-of-the-linked-list/description/
public class MiddleoftheLinkedList {

    public static ListNode middleNode(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
