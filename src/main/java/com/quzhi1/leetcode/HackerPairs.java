package com.quzhi1.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;

public class HackerPairs {

  static int pairs(int k, int[] arr) {
    Set<Integer> targets = new HashSet<>();
    int[] sorted = Arrays.stream(arr)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .mapToInt(Integer::intValue)
        .toArray();
    int result = 0;
    for (int num : sorted) {
      if (targets.contains(num)) {
        result++;
      }
      targets.add(num - k);
      targets.add(num - k);
    }
    return result;
  }

  public static void main(String[] args) {
    Assert.assertEquals(3, pairs(1, new int[]{1, 2, 3, 4}));
    Assert.assertEquals(3, pairs(2, new int[]{1, 5, 3, 4, 2}));
  }
}
