package com.quzhi1.leetcode;

public class Leet69 {

  public static int mySqrt(int x) {
    if (x == 0 || x == 1) {
      return x;
    }
    return mySqrtRecursive(x, 1, x - 1);
  }

  private static int mySqrtRecursive(int x, int lower, int upper) {
    if (upper - lower <= 1) {
      return Math.min(upper, lower);
    } else {
      int mid = (int) Math.floor(lower / 2.0 + upper / 2.0);
      if (1.0 * mid > 1.0 * x / mid) {
        return mySqrtRecursive(x, lower, mid);
      } else if (1.0 * mid == 1.0 * x / mid) {
        return mid;
      } else {
        return mySqrtRecursive(x, mid, upper);
      }
    }
  }

  public static void main(String[] main) {
    System.out.println(mySqrt(4));
    System.out.println(mySqrt(8));
    System.out.println(mySqrt(1));
    System.out.println(mySqrt(16));
    System.out.println(mySqrt(17));
    System.out.println(mySqrt(2147395599)); // 46339
  }

}
