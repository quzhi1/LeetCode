package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet322 {

  public static int coinChange(int[] coins, int amount) {
    Map<Integer, Integer> amountMap = new HashMap<>();
    return coinRecursive(coins, amount, amountMap);
  }

  private static int coinRecursive(int[] coins, int amount, Map<Integer, Integer> amountMap) {
    if (amount == 0) {
      return 0;
    }
    if (amountMap.get(amount) != null) {
      return amountMap.get(amount);
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < coins.length; i++) {
      if (amount - coins[i] == 0) {
//        System.out.println("Amount " + amount + " need 1 coin");
        amountMap.put(amount, 1);
        return 1;
      } else if (amount - coins[i] > 0) {
        int leastCoins = coinRecursive(coins, amount - coins[i], amountMap);
        if (leastCoins != -1) {
          min = Math.min(leastCoins + 1, min);
        }
      }
    }
    if (min == Integer.MAX_VALUE) {
//      System.out.println("Amount " + amount + " impossible");
      amountMap.put(amount, -1);
      return -1;
    } else {
//      System.out.println("Amount " + amount + " need " + min + " coins");
      amountMap.put(amount, min);
      return min;
    }
  }

  public static void main(String[] main) {
    System.out.println(coinChange(new int[]{1, 2, 5}, 11));  // 3
    System.out.println(coinChange(new int[]{2}, 3));  // -1
    System.out.println(coinChange(new int[]{1}, 0));  // 0
    System.out.println(coinChange(new int[]{474, 83, 404, 3}, 264));  // 8
  }
}
