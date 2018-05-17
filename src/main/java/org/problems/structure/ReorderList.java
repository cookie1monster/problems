package org.problems.structure;

//https://leetcode.com/problems/reorder-list/description/
public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null && next.next != null) {
            cur = cur.next;
            next = next.next.next;
        }

        ListNode cur2 = reverse(cur.next);
        cur.next = null;
        cur = head;
        while (cur != null && cur2 != null) {
            next = cur.next;
            cur.next = cur2;
            cur2 = next;
            cur = cur.next;
        }
    }

    public static ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        ListNode next = head.next;

        while (next != null) {
            ListNode next2 = next.next;
            next.next = cur;
            cur = next;
            next = next2;
        }
        head.next = null;
        return cur;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        reorderList(new ListNode(1));
        reorderList(null);
        System.out.println();
    }

}
