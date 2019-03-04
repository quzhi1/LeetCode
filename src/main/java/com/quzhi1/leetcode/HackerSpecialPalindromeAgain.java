package com.quzhi1.leetcode;

import org.junit.Assert;

public class HackerSpecialPalindromeAgain {

  static long substrCount(int n, String s) {
    if (s == null || n == 0) {
      return 0;
    } else if (n == 1) {
      return 1L;
    }
    int result = n;
    for (int i = 0; i < n; i++) {
      result += expandOdd(s, i);
      result += expandEven(s, i);
//      System.out.println("Index " + i + ": " + s.charAt(i) + " has odd: " + expandOdd(s, i) +
//          ", even: " + expandEven(s, i));
    }
    return result;
  }

  private static long expandOdd(String s, int index) {
    int result = 0;
    int left = index - 1;
    int right = index + 1;
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right) && s.charAt(left) == s.charAt(index - 1)) {
      left--;
      right++;
      result++;
    }
    return result;
  }

  private static long expandEven(String s, int index) {
    int result = 0;
    int left = index;
    int right = index + 1;
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right) && s.charAt(index) == s.charAt(left)) {
      left--;
      right++;
      result++;
    }
    return result;
  }

  public static void main(String[] args) {
    Assert.assertEquals(7, substrCount(5, "asasd"));
    Assert.assertEquals(10, substrCount(7, "abcbaba"));
    Assert.assertEquals(10, substrCount(4, "aaaa"));
  }

}
