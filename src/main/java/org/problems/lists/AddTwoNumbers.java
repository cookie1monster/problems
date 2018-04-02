package org.problems.lists;

//https://leetcode.com/problems/add-two-numbers/description/
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = 0;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1 != null || l2 != null) {
            val = val / 10;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(val % 10);
            curr = curr.next;
        }
        if (val > 9) {
            curr.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println();
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
