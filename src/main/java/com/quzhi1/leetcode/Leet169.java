package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet169 {

  public static int majorityElement(int[] nums) {
    Map<Integer, Integer> freqMap = new HashMap<>();
    int max = 0;
    Integer maxKey = null;
    for (int num : nums) {
      freqMap.merge(num, 1, (i1, i2) -> i1 + 1);
      if (freqMap.get(num) > max) {
        max = freqMap.get(num);
        maxKey = num;
      }
    }
    return maxKey;
  }

  public static void main(String[] args) {
    System.out.println(majorityElement(new int[]{3, 2, 3})); // 3
    System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})); // 1 or 2
  }

}
