package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HackerSockMerchant {

  static int sockMerchant(int n, int[] ar) {
    Map<Integer, Integer> sockNum = new HashMap<>();
    for (int sock : ar) {
      sockNum.merge(sock, 1, (i1, i2) -> i1 + 1);
    }
    int result = 0;
    for (Map.Entry<Integer, Integer> entry: sockNum.entrySet()) {
      result += entry.getValue() / 2;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(sockMerchant(7, new int[]{1, 2, 1, 2, 1, 3, 2})); // 2
    System.out.println(sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20})); // 3
  }
}
