package org.problems.lists;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode arrToList(int[] arr) {
        if (arr.length == 0)
            return null;
        ListNode root = new ListNode(0);
        ListNode node = root;
        for (int num : arr) {
            node.next = new ListNode(num);
            node = node.next;
        }
        return root.next;
    }
}
