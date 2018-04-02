package org.problems.lists;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class RemoveNthNodeFromEndList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lo = head;
        ListNode hi = head.next;
        while (hi != null && n > 0) {
            hi = hi.next;
            --n;
        }
        if (hi == null && n > 0)
            return head.next;
        while (hi != null) {
            hi = hi.next;
            lo = lo.next;
        }
        lo.next = lo.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        System.out.println(removeNthFromEnd(l1, 2).val);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
