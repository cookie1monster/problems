package org.problems.structure;

import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

//https://leetcode.com/problems/lru-cache/description/
public class LRUCacheMain {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);                        // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

        System.out.println("--------");

        cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}

class LRUCache {

    private final Map<Integer, Integer> cache;
    private final Deque<Integer> lastUsed;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lastUsed = new ConcurrentLinkedDeque<>();
        cache = new ConcurrentHashMap<>(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            lastUsed.remove(key);
            lastUsed.addFirst(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.size() == capacity && !cache.containsKey(key)) {
            cache.remove(lastUsed.pollLast());
        }
        if (cache.containsKey(key)) {
            lastUsed.remove(key);
        }
        lastUsed.addFirst(key);
        cache.put(key, value);
    }
}