package com.quzhi1.leetcode;

public class Leet172 {

  // Please remember this solution. Best I can think of:
  // https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52371/My-one-line-solutions-in-3-languages

  public static int trailingZeroes(int n) {
    return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
  }

  public static void main(String[] args) {
    System.out.println(trailingZeroes(0));
    System.out.println(trailingZeroes(5));
    System.out.println(trailingZeroes(28));
    System.out.println(trailingZeroes(100));
  }
}
