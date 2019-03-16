package com.quzhi1.leetcode;

import org.junit.Assert;

public class AirbnbConsecutiveSum {

  // See leet829
  public static int consecutive(long num) {
    while ((num & 1) == 0) {
      num >>= 1;
    }
    int ans = 1, d = 3;

    while (d * d <= num) {
      int e = 0;
      while (num % d == 0) {
        num /= d;
        e++;
      }
      ans *= e + 1;
      d += 2;
    }

    if (num > 1) {
      ans <<= 1;
    }
    return ans - 1;
  }

  public static void main(String[] args) {
    Assert.assertEquals(3, consecutive(15));
    Assert.assertEquals(1, consecutive(10));
  }
}
