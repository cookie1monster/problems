package org.problems.structure;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//https://leetcode.com/problems/lfu-cache/description/
public class LFUCacheMain {

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2 /* capacity */);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // returns 1
//        cache.put(3, 3);                        // evicts key 2
//        System.out.println(cache.get(2));       // returns -1 (not found)
//        cache.put(4, 4);                        // evicts key 1
//        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4
//
//        System.out.println("--------");
//
//        cache = new LRUCache(2);
//        System.out.println(cache.get(2));
//        cache.put(2, 6);
//        System.out.println(cache.get(1));
//        cache.put(1, 5);
//        cache.put(1, 2);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//
//        System.out.println("--------");
//
//        cache = new LRUCache(1);
//        cache.put(2, 1);
//        System.out.println(cache.get(2));
//        cache.put(3, 2);
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(3));
//
//
//

//        System.out.println("--------");
//
//        cache = new LRUCache(2);
//        cache.put(2, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(2));
//        cache.put(1, 1);
//        cache.put(4, 1);
//        System.out.println(cache.get(2));


        System.out.println("--------");

        cache = new LFUCache(2);
        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(3));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}


class LFUCache {

    class Node {
        int val, key;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class ListNode {
        private Map<Integer, Node> cache;
        private Node head, tail;

        ListNode() {
            cache = new ConcurrentHashMap<>();
        }

        public int size() {
            return cache.size();
        }

        public Node pull(int key) {
            Node node = removeNode(key);
            if (node == null)
                return null;
            return node;
        }

        public void add(Node node) {
            cache.put(node.key, node);
            if (head == null) {
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
            }
            head = node;
        }

        public void add(int key, int val) {
            add(new Node(key, val));
        }

        public Node removeNode(int key) {
            Node node = cache.get(key);
            if (node != null) {
                cache.remove(key);
                if (cache.size() == 0) {
                    head = null;
                    tail = null;
                    return node;
                }
                if (node == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else if (node == head) {
                    head = head.next;
                    head.prev = null;
                } else {
                    Node prev = node.prev;
                    Node next = node.next;
                    prev.next = next;
                    next.prev = prev;
                }
                node.next = null;
                node.prev = null;
            }
            return node;
        }

        public int removeTail() {
            int key = tail.key;
            cache.remove(key);
            if (tail == head) {
                tail = null;
                head = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            return key;
        }

    }

    private Map<Integer, Long> freq;
    private Map<Long, ListNode> group;
    private int capacity;
    private long minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        freq = new ConcurrentHashMap<>(capacity + 1);
        group = new ConcurrentHashMap<>();
        minFreq = 1L;
    }

    public int get(int key) {
        if (capacity == 0)
            return -1;
        Node node = moveNode(key);
        if (node == null)
            return -1;
        return node.val;
    }

    private Node moveNode(int key) {
        Long freqKey = freq.get(key);
        if (freqKey != null) {
            ListNode listNode = group.get(freqKey);
            Node node = listNode.pull(key);
            ++freqKey;
            freq.put(key, freqKey);
            group.computeIfAbsent(freqKey, z -> new ListNode()).add(node);
            return node;
        }
        return null;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        Node node = moveNode(key);
        if (node == null) {
            if (freq.size() == capacity) {
                while (group.get(minFreq).size() == 0)
                    ++minFreq;

                int keyToRemove = group.get(minFreq).removeTail();
                freq.remove(keyToRemove);
            }
            minFreq = 1L;
            freq.put(key, minFreq);
            group.computeIfAbsent(minFreq, z -> new ListNode()).add(key, value);
        } else if (node.val != value)
            node.val = value;

    }
}
