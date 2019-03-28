package com.quzhi1.leetcode;

import org.junit.Assert;

public class HackerMaxArraySum {

  static int maxSubsetSum(int[] arr) {
    int[] dp = new int[100000];
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        dp[i] = arr[0];
      } else if (i == 1) {
        dp[i] = Math.max(arr[0], arr[1]);
      } else {
        int maxBeforeBefore = dp[i - 2];
        int maxBefore = dp[i - 1];
        dp[i] = Math.max(arr[i],
            Math.max(arr[i] + maxBeforeBefore,
                Math.max(maxBeforeBefore, maxBefore)));
      }
    }
    return dp[arr.length - 1];
  }

  public static void main(String[] args) {
    Assert.assertEquals(13, maxSubsetSum(new int[]{3, 7, 4, 6, 5}));
    Assert.assertEquals(11, maxSubsetSum(new int[]{2, 1, 5, 8, 4}));
  }
}
