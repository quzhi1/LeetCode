package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Leet146 {

  static class LRUCache {

    private final Map<Integer, Integer> keyValue = new HashMap<>();
    private final LinkedList<CacheEntry> cache = new LinkedList<>();
    private final int capacity;

    public LRUCache(int capacity) {
      this.capacity = capacity;
    }

    public int get(int key) {
      if (keyValue.get(key) != null) {
        Integer value = keyValue.get(key);
        cache.remove(new CacheEntry(key, value));
        cache.addLast(new CacheEntry(key, value));
        return value;
      } else {
        return -1;
      }
    }

    public void put(int key, int value) {
      if (keyValue.get(key) != null) {
        int oldValue = keyValue.get(key);
        keyValue.put(key, value);
        cache.remove(new CacheEntry(key, oldValue));
      } else {
        keyValue.put(key, value);
      }
      cache.addLast(new CacheEntry(key, value));

      // Evict
      if (cache.size() > capacity) {
        CacheEntry head = cache.removeFirst();
        keyValue.remove(head.key);
//        System.out.println("Evicting " + head.key);
      }
    }

    static class CacheEntry {

      final int key, value;

      CacheEntry(final int key, final int value) {
        this.key = key;
        this.value = value;
      }

      @Override
      public boolean equals(Object target) {
        if (target instanceof CacheEntry) {
          CacheEntry targetEntry = ((CacheEntry) target);
          return targetEntry.key == this.key && targetEntry.value == this.value;
        } else {
          return false;
        }
      }
    }
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));       // returns 1
    cache.put(3, 3);    // evicts key 2
    System.out.println(cache.get(2));       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    System.out.println(cache.get(1));       // returns -1 (not found)
    System.out.println(cache.get(3));       // returns 3
    System.out.println(cache.get(4));       // returns 4
  }
}
