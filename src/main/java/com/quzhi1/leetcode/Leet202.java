package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet202 {

  public static boolean isHappy(int n) {
    Map<Map<Integer, Integer>, Integer> records = new HashMap<>();
    while (true) {
      if (n == 1) {
        return true;
      } else if (n == -1) {
        return false;
      }
      n = dissect(n, records);
    }
  }

  private static int dissect(int n, Map<Map<Integer, Integer>, Integer> records) {
    Map<Integer, Integer> newRecord = new HashMap<>();
    int sum = 0;
    int base = n;
    do {
      int remainder = base % 10;
      newRecord.merge(remainder, 1, (i1, i2) -> i1 + 1);
      sum += remainder * remainder;
      base = base / 10;
    } while (base > 0);
    if (records.containsKey(newRecord)) {
      return -1;
    } else {
      records.put(newRecord, sum);
      return sum;
    }
  }

  public static void main(final String[] args) {
//    System.out.println(isHappy(19));
//    System.out.println(isHappy(0));
//    System.out.println(isHappy(1001));
    System.out.println(isHappy(7));
  }
}
