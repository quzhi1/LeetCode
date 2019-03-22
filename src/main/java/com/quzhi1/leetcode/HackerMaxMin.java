package com.quzhi1.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;

public class HackerMaxMin {

  static int maxMin(int k, int[] arr) {
    if (arr == null || arr.length < 2) {
      return 0;
    }
    List<Integer> arrList = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < arrList.size() - k + 1; i++) {
      minDiff = Math.min(minDiff, arrList.get(i + k - 1) - arrList.get(i));
    }
    return minDiff;
  }

  public static void main(String[] args) {
    Assert.assertEquals(20, maxMin(3, new int[]{10, 100, 300, 200, 1000, 20, 30}));
  }
}
