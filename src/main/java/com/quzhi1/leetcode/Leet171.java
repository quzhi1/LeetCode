package com.quzhi1.leetcode;

public class Leet171 {

  public static int titleToNumber(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int result = 0;
    for (int i = s.length() - 1; i > -1; i--) {
      int digit = s.charAt(i) - 'A' + 1;
      result += digit * Math.pow(26, (s.length() - 1 - i));
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(titleToNumber("A")); // 1
    System.out.println(titleToNumber("AB")); // 28
    System.out.println(titleToNumber("ZY")); // 701
  }

}
