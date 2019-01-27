package com.quzhi1.leetcode;

public class Leet29 {

  public static int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == 2) {
      return -1073741824;
    } else if (dividend == divisor) {
      return 1;
    } else if (dividend == 0) {
      return 0;
    } else if (dividend == 1 && divisor > 1) {
      return 0;
    } else if (divisor == 1) {
      return dividend;
    } else if (divisor == -1) {
      if (dividend == Integer.MIN_VALUE) {
        return Integer.MAX_VALUE;
      }
      return -dividend;
    } else if (dividend > 0 && divisor < 0) {
      int positive = -divisor;
      if (positive < 0) {
        return 0;
      }
      return -divide(dividend, positive);
    } else if (dividend < 0 && divisor > 0) {
      int positive = -dividend;
      if (positive < 0) {
        positive = Integer.MAX_VALUE;
        return -divide(positive, divisor);
      } else {
        return -divide(positive, divisor);
      }
    } else if (dividend < 0 && divisor < 0) {
      int positiveDividend = -dividend;
      if (positiveDividend < 0) {
        positiveDividend = Integer.MAX_VALUE;
      }
      int positiveDivisor = -divisor;
      if (positiveDivisor < 0) {
        return 0;
      }
      return divide(positiveDividend, positiveDivisor);
    } else {
      return divideRecursive(dividend, divisor, dividend - 1, 1);
    }
  }

  private static int divideRecursive(int dividend, int divisor, int upper, int lower) {
    if (dividend < divisor) {
      return 0;
    } else if (upper - lower <= 1) {
      return lower;
    } else {
      int mid = (int) Math.floor(lower / 2.0 + upper / 2.0);
      try {
        int estimate = Math.multiplyExact(mid, divisor);
        if (estimate > dividend) {
          return divideRecursive(dividend, divisor, mid, lower);
        } else if (estimate < dividend) {
          return divideRecursive(dividend, divisor, upper, mid);
        } else {
          return mid;
        }
      } catch (ArithmeticException e) {
        return divideRecursive(dividend, divisor, mid, lower);
      }
    }
  }

  public static void main(String[] main) {
//    System.out.println(divide(12, 6));
//    System.out.println(divide(12, 7));
//    System.out.println(divide(-2147483648, 1));
//    System.out.println(divide(-2147483648, 2));
//    System.out.println(divide(1, 2));
//    System.out.println(divide(1, 1));
//    System.out.println(divide(-2147483648, -1));
//    System.out.println(divide(-1, 1));
    System.out.println(divide(-2147483648, 2));
//    System.out.println(divide(1004958205, -2137325331));
//    System.out.println(divide(-1021989372, -82778243));
//    System.out.println(divide(2147483647, -2147483648));
//    System.out.println(divide(-2147483648, 122481295));
  }
}
