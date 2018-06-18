package org.problems.lists;

//https://leetcode.com/problems/add-two-numbers-ii/description/
public class AddTwoNumbers2 {

    private static ListNode addOne(ListNode l1, ListNode to, ListNode toMerge) {
        if (l1.next == to) {
            int val = 0;
            if (toMerge.val > 9) {
                toMerge.val -= 10;
                val = 1;
            }
            ListNode node = new ListNode(l1.val + val);
            node.next = toMerge;
            return node;
        }
        ListNode nextNode = addOne(l1.next, to, toMerge);
        ListNode node = new ListNode(l1.val);
        if (nextNode != null && nextNode.val > 9) {
            nextNode.val -= 10;
            ++node.val;
        }
        node.next = nextNode;
        return node;
    }

    private static ListNode addTwoNumbersRecur(ListNode l1, ListNode l2) {
        if (l1.next == null) {
            return new ListNode(l1.val + l2.val);
        }
        ListNode nextNode = addTwoNumbersRecur(l1.next, l2.next);
        ListNode node = new ListNode(l1.val + l2.val);
        if (nextNode != null && nextNode.val > 9) {
            nextNode.val -= 10;
            ++node.val;
        }
        node.next = nextNode;
        return node;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Length = 0;
        ListNode node = l1;
        while (node != null) {
            ++l1Length;
            node = node.next;
        }

        int l2Length = 0;
        node = l2;
        while (node != null) {
            ++l2Length;
            node = node.next;
        }

        if (l1Length == l2Length) {
            node = addTwoNumbersRecur(l1, l2);
        } else {
            ListNode first = l1;
            ListNode second = l2;
            if (l2Length > l1Length) {
                first = l2;
                second = l1;
            }
            int diff = Math.abs(l2Length - l1Length);
            ListNode lHead = first;
            while (diff-- > 0)
                first = first.next;

            ListNode tmp = addTwoNumbersRecur(first, second);
            node = addOne(lHead, first, tmp);
        }

        ListNode head = node;
        if (node.val > 9) {
            head = new ListNode(1);
            node.val -= 10;
            head.next = node;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(7);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        ListNode l14 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;


        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode node = addTwoNumbers(l11, l21);
        System.out.println();
    }
}
