package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HackerIceCreamParlor {

  static void whatFlavors(int[] cost, int money) {
    Map<Integer, Integer> reverseLookUp = new HashMap<>();
    for (int i = 0; i < cost.length; i++) {
      if (reverseLookUp.containsKey(cost[i])) {
        System.out.println((Math.min(i, reverseLookUp.get(cost[i])) + 1) + " " +
            (Math.max(i, reverseLookUp.get(cost[i])) + 1));
        return;
      } else {
        reverseLookUp.put(money - cost[i], i);
      }
    }
  }

  public static void main(String[] args) {
    whatFlavors(new int[]{1, 4, 5, 3, 2}, 4); // 1 4
    whatFlavors(new int[]{2, 2, 4, 3}, 4); // 1 2
  }
}
