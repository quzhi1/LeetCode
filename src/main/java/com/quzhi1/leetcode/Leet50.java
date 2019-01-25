package com.quzhi1.leetcode;

public class Leet50 {

  public static double myPow(double x, int n) {
    // If x is -1, 1, 0. O(1)
    if (x == 1 || x == 0) {
      return x;
    } else if (x == -1) {
      return n % 2 == 0 ? -x : x;
    }

    // This check is stupid, check to pass Integer.MIN_VALUE test
    if (n == Integer.MIN_VALUE) {
      return myPow(x, Integer.MIN_VALUE + 1) / x;
    }

    // Normal case
    if (n == 0) {
      return 1;
    } else if (n > 0) {
      if (n % 2 == 0) {
        return myPow(x * x, n / 2);
      } else {
        return myPow(x * x, (n - 1) / 2) * x;
      }
    } else {
      return 1 / myPow(x, -n);
    }
  }

  public static void main(String[] args) {
    System.out.println(myPow(2, 10)); // 1024
    System.out.println(myPow(2.1, 3)); // 9.261
    System.out.println(myPow(2, -2)); // 0.25
    System.out.println(myPow(1, Integer.MAX_VALUE)); // 1
    System.out.println(myPow(-1, Integer.MAX_VALUE)); // -1
    System.out.println(myPow(-1, Integer.MAX_VALUE - 1)); // 1
    System.out.println(myPow(2, Integer.MIN_VALUE)); // nearly 0
  }

}
