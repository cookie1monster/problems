package org.problems.recursion;

//https://leetcode.com/problems/subsets/description/
public class IntersectionTwoLinkedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        while (curA != null) {
            curA = curA.next;
            ++lenA;
        }
        while (curB != null) {
            curB = curB.next;
            ++lenB;
        }

        curA = headA;
        curB = headB;
        int len = Math.abs(lenA - lenB);
        if (lenB > lenA) {
            curA = headB;
            curB = headA;
        }
        while (len > 0) {
            curA = curA.next;
            --len;
        }

        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }


    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode b1 = new ListNode(3);
        ListNode c1 = new ListNode(4);
        ListNode c2 = new ListNode(5);
        ListNode c3 = new ListNode(6);

        a1.next = a2;
        a2.next = c1;
        b1.next = c1;
        c1.next = c2;
        c2.next = c3;

        System.out.println(getIntersectionNode(a1, b1).val);
    }
}
