package com.quzhi1.leetcode;

import java.util.Arrays;
import org.junit.Assert;

public class HackerMinimumTimeRequired {

  static long minTime(long[] machines, long goal) {
    long right = goal * Arrays.stream(machines).min().getAsLong();
    long left = right / machines.length;
    while (left < right - 1) {
      long mid = (left + right) >>> 1;    // Avoids overflow
      if (goal > Arrays.stream(machines).map(i -> mid / i).sum()) {
        left = mid;
      } else {
        right = mid;
      }
    }
    return right;
  }

  public static void main(String[] args) {
    Assert.assertEquals(8, minTime(new long[]{2, 5}, 5));
    Assert.assertEquals(10, minTime(new long[]{2, 5}, 6));
  }

}
