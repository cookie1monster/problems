package org.problems.sort;

//https://leetcode.com/problems/sort-list/description/
public class SortLinkedList {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = null;
        ListNode eq = head;
        ListNode right = null;

        ListNode curr = head.next;
        head.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            if (curr.val == head.val) {
                curr.next = eq;
                eq = curr;
            } else if (curr.val < head.val) {
                curr.next = left;
                left = curr;
            } else {
                curr.next = right;
                right = curr;
            }
            curr = next;
        }

        curr = head;
        if (left != null) {
            head = sortList(left);
            ListNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = eq;
        } else {
            head = eq;
        }
        curr.next = sortList(right);

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(4);
        l2.next = l3;
        ListNode res = sortList(l1);
        System.out.println(res);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
