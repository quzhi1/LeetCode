package com.quzhi1.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HackerNonDivisibleSubset {

  static int nonDivisibleSubset(int k, int[] S) {
    Map<Integer, Integer> modFreq = new HashMap<>();
    Arrays.stream(S).forEach(s -> modFreq.merge(s % k, 1, (i1, i2) -> i1 + 1));
//    modFreq.forEach((key, value) -> System.out.println(key + ": " + value));
    Set<Map.Entry<Integer, Integer>> entries = modFreq.entrySet();
    Set<Integer> resultSet = new HashSet<>();
    int result = 0;
    for (Map.Entry<Integer, Integer> entry : entries) {
      Integer key = entry.getKey();
      if (key == 0 || key * 2 == k) {
        result++;
        resultSet.add(key);
      } else if (modFreq.containsKey(k - key) && !resultSet.contains(k - key) && !resultSet.contains(key)) {
//        System.out.println("Found pair: " + key + " - " + (k - key));
        if (modFreq.get(key) > modFreq.get(k - key)) {
//          System.out.println("Choose " + key);
          result += modFreq.get(key);
          resultSet.add(key);
        } else {
//          System.out.println("Choose " + (k - key));
          result += modFreq.get(k - key);
          resultSet.add(k - key);
        }
      } else if (!resultSet.contains(k - key) && !resultSet.contains(key)) {
//        System.out.println("Choose " + key);
        result += entry.getValue();
        resultSet.add(key);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(nonDivisibleSubset(4, new int[]{19, 10, 12, 10, 24, 25, 22})); // 3
    System.out.println(nonDivisibleSubset(7,
            new int[]{278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436})); // 11
  }
}
