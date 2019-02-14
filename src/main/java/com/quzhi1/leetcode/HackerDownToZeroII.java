package com.quzhi1.leetcode;

public class HackerDownToZeroII {

  private static final int[] stepList = new int[1000001];

  static int downToZeroMySolution(int n) {
    if (n <= 3) {
      return n;
    } else if (stepList[n] > 0) {
      return stepList[n];
    } else {
      int findSmallestBigFactor = smallestBigFactor(n);
      if (findSmallestBigFactor != n) {
        int smallestBigFactor = downToZeroMySolution(findSmallestBigFactor);
        int minus = downToZeroMySolution(n - 1);
        stepList[n] = Math.min(smallestBigFactor, minus) + 1;
      } else {
        stepList[n] = downToZeroMySolution(n - 1) + 1;
      }
      return stepList[n];
    }
  }

  private static int smallestBigFactor(int n) {
//    if (isPrime(n)) {
//      return n;
//    }
    int startingPoint = (int) Math.ceil(Math.sqrt(n));
    for (int i = startingPoint; i < n; i++) {
      if (n % i == 0) {
        return i;
      }
    }
    return n;
  }

  static int downToZero(int n) {
    if (n <= 3) {
      return n;
    }
    if (stepList[n] > 0) {
      return stepList[n];
    }
    int min = Integer.MAX_VALUE;
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        int factor = n / i;
        min = Math.min(min, 1 + downToZero(factor));
      }
    }
    min = Math.min(min, 1 + downToZero(n - 1));
//    System.out.println(n);
    stepList[n] = min;
    return min;
  }

//  private static boolean isPrime(int n) {
//    if (n <= 1) {
//      return false;
//    }
//    if (n <= 3) {
//      return true;
//    }
//    if (n % 2 == 0 || n % 3 == 0) {
//      return false;
//    }
//    for (int i = 5; i * i <= n; i = i + 6) {
//      if (n % i == 0 || n % (i + 2) == 0) {
//        return false;
//      }
//    }
//    return true;
//  }

  public static void main(String[] args) {
//    System.out.println(downToZero(3)); // 3
//    System.out.println(downToZero(4)); // 3
//    System.out.println(downToZero(6)); // 4
    System.out.println(downToZero(100)); // 4
//    System.out.println(downToZero(16)); // 4
//    System.out.println(downToZero(10)); // 5
//    System.out.println(downToZero(14)); // 6
//    System.out.println(downToZero(12)); // 4
//    System.out.println("-----------------------------");
//    for (int i = 0; i < cap; i++) {
//      System.out.println(i + ": " + stepList[i]);
//    }
  }

}
