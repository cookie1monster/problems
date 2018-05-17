package org.problems.structure;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;


//https://leetcode.com/problems/merge-k-sorted-lists/description/
public class MergeKLists {

    public static void add(SortedMap<ListNode, ListNode> set, ListNode val) {
        ListNode node;
        ListNode temp;
        if (val != null) {
            node = set.get(val);
            if (node != null) {
                temp = node.next;
                node.next = val;
                add(set, val.next);
                val.next = temp;
            } else {
                set.put(val, val);
            }
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        SortedMap<ListNode, ListNode> set = new TreeMap<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; ++i) {
            add(set, lists[i]);
        }
        if (set.size() == 0) {
            return null;
        }
        ListNode first = set.firstKey();
        ListNode node = first;
        while (node != null) {
            set.remove(node);
            while (node.next != null && node.val == node.next.val) {
                node = node.next;
            }
            add(set, node.next);
            if (set.size() > 0) {
                node.next = set.firstKey();
            }
            node = node.next;
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;

        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(1);
        l3.next = l4;
        mergeKLists(new ListNode[] { l4 });
        //mergeKLists(new ListNode[]{l1,l3});
    }

    static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode node1, ListNode node2) {
            return (node1 == null || node2 == null) ? -1 : Integer.compare(node1.val, node2.val);
        }
    }

}
