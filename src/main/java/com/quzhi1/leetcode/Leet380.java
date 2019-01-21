package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class Leet380 {

  static class RandomizedSet {

    private final LinkedList<Integer> list = new LinkedList<>();
    private final Map<Integer, Integer> locationMap = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
      if (locationMap.containsKey(val)) {
        return false;
      } else {
        list.addLast(val);
        locationMap.put(val, list.size() - 1);
        return true;
      }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
      if (!locationMap.containsKey(val)) {
        return false;
      } else if (list.size() == 1) {
        locationMap.clear();
        list.clear();
        return true;
      } else if (locationMap.get(val) == list.size() - 1) {
        // last element
        locationMap.remove(val);
        list.removeLast();
        return true;
      } else {
        int location = locationMap.remove(val);
        locationMap.put(list.getLast(), location);
        list.set(location, list.getLast());
        list.removeLast();
        return true;
      }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
      if (list.isEmpty()) {
        throw new RuntimeException("Empty set");
      }
      Random random = new Random();
      return list.get(random.nextInt(list.size()));
    }
  }

  public static void main(String[] main) {
    RandomizedSet randomSet = new RandomizedSet();
//    randomSet.insert(1);
//    randomSet.remove(2);
//    randomSet.insert(2);
//    randomSet.getRandom();
//    randomSet.remove(1);
//    randomSet.insert(2);
//    randomSet.getRandom();

//    System.out.println(randomSet.remove(0));
//    System.out.println(randomSet.remove(0));
//    System.out.println(randomSet.insert(0));
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.remove(0));
//    System.out.println(randomSet.insert(0));

//    System.out.println(randomSet.insert(3));
//    System.out.println(randomSet.insert(3));
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.insert(1));
//    System.out.println(randomSet.remove(3));
//    System.out.println(randomSet.remove(3));
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.insert(0));
//    System.out.println(randomSet.remove(0));

//    System.out.println(randomSet.insert(3));
//    System.out.println(randomSet.insert(-2));
//    System.out.println(randomSet.remove(2));
//    System.out.println(randomSet.insert(1));
//    System.out.println(randomSet.insert(-3));
//    System.out.println(randomSet.insert(-2));
//    System.out.println(randomSet.remove(-2));
//    System.out.println(randomSet.remove(3));
//    System.out.println(randomSet.insert(-1));
//    System.out.println(randomSet.remove(-3));
//    System.out.println(randomSet.insert(1));
//    System.out.println(randomSet.insert(-2));
//    System.out.println(randomSet.insert(-2));
//    System.out.println(randomSet.insert(-2));
//    System.out.println(randomSet.insert(1));
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.insert(-2));
//    System.out.println(randomSet.remove(0));
//    System.out.println(randomSet.insert(-3));
//    System.out.println(randomSet.insert(1));

//    System.out.println(randomSet.insert(0));
//    System.out.println(randomSet.remove(0));
//    System.out.println(randomSet.insert(-1));
//    System.out.println(randomSet.remove(0));
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.getRandom());
//    System.out.println(randomSet.getRandom());
  }

}
