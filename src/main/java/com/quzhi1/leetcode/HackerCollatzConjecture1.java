package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;

public class HackerCollatzConjecture1 {

  private static Map<Integer, Integer> resultMap = new HashMap<>();

  static {
    resultMap.put(1, 1);
  }

  public static int collatzConjecture(int n) {
    if (n < 1) {
      throw new IllegalArgumentException("n < 1");
    } else if (n == 1) {
      return 0;
    } else if (resultMap.containsKey(n)) {
      return resultMap.get(n);
    } else if (n % 2 == 0) {
      int result = collatzConjecture(n / 2) + 1;
      resultMap.put(n, result);
      return result;
    } else {
      int result = collatzConjecture(n * 3 + 1) + 1;
      resultMap.put(n, result);
      return result;
    }
  }

  public static void main(String[] args) {
    Assert.assertEquals(15, collatzConjecture(22));
    Assert.assertEquals(6, collatzConjecture(10));
  }
}
