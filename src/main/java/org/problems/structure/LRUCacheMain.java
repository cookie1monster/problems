package org.problems.structure;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//https://leetcode.com/problems/lru-cache/description/
public class LRUCacheMain {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);
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

        cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}


class LRUCache {

    class Node {
        int val, key;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final Map<Integer, Node> cache;
    private final int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new ConcurrentHashMap<>(capacity + 1);
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.val = value;
            moveToHead(node);
        } else {
            if (cache.size() == capacity) {
                int keyToRemove = tail.key;
                tail = tail.prev;
                cache.remove(keyToRemove);
            }
            Node newNode = new Node(key, value);
            addHead(newNode);
            cache.put(key, newNode);
        }
    }

    private void moveToHead(Node node) {
        if (cache.size() == 1 || node == head)
            return;
        if (node == tail) {
            tail = node.prev;
        } else {
            Node prev = node.prev;
            Node next = node.next;
            if (prev != null) prev.next = next;
            if (next != null) next.prev = prev;
        }
        addHead(node);
    }

    private void addHead(Node node) {
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        } else {
            tail = node;
        }
        head = node;
    }
}

///////////////////////////////

class LRUCache1 {

    private final Map<Integer, Integer> cache;

    public LRUCache1(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>((int) ((capacity + 1) / 0.75), 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}