package org.problems.structure;

//https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class ReverseNodeskGroup {

    private static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        int size = 0;
        ListNode node = head;
        while (node != null) {
            ++size;
            node = node.next;
        }

        int i = 1;
        node = head;
        ListNode start = null;
        ListNode cur = null;
        ListNode end = null;
        if (size - k < 0)
            return head;
        head = null;
        while (i <= size - (size % k)) {
            cur = node;
            node = node.next;
            if (i % k == 0) {
                cur.next = start;
                if (head == null)
                    head = cur;
                else if (end != null) {
                    end.next = cur;
                    end = cur;
                    int j = k - 1;
                    while (j > 0) {
                        --j;
                        end = end.next;
                    }
                }
                start = null;
            } else {
                if (start == null) {
                    start = cur;
                    if (end == null)
                        end = cur;
                } else {
                    cur.next = start;
                    start = cur;
                }
            }
            ++i;

        }
        if (size - k >= 0)
            end.next = node;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        l1.next = l2;
        //l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        ListNode head = reverseKGroup(l1, 2);
        System.out.println(head);
    }
}
