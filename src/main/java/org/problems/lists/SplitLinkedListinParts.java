package org.problems.lists;

//https://leetcode.com/problems/split-linked-list-in-parts/description/
public class SplitLinkedListinParts {

    public static ListNode[] splitListToParts(ListNode root, int k) {
        int len = findListLength(root);
        int residue = len % k;
        int backetSize = len / k;

        ListNode[] res = new ListNode[k];
        int i = 0;
        ListNode node = root;
        int curBacketSize = 0;
        while (node != null) {
            if (curBacketSize == 0) {
                res[i++] = node;
            }
            int expectedSize = backetSize + ((residue > 0) ? 1 : 0);
            if (expectedSize == 1 || curBacketSize == expectedSize - 1) {
                curBacketSize = 0;
                --residue;
                ListNode tmp = node;
                node = node.next;
                tmp.next = null;
            } else {
                ++curBacketSize;
                node = node.next;
            }
        }

        return res;
    }

    private static int findListLength(ListNode node) {
        int len = 0;
        while (node != null) {
            ++len;
            node = node.next;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(splitListToParts(ListNode.arrToList(new int[]{1, 2, 3, 4}), 3));
    }
}
