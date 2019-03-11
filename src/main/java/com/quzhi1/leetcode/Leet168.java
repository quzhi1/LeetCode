package com.quzhi1.leetcode;

import org.junit.Assert;

public class Leet168 {

  public static String convertToTitle(int n) {
    return convert(n - 1);
  }

  private static String convert(int n) {
    if (n > 25) {
      return convert(n / 26 - 1) + (char) ('A' + n % 26);
    } else {
      return String.valueOf((char) ('A' + n));
    }
  }

  public static void main(String[] args) {
    Assert.assertEquals("A", convertToTitle(1));
    Assert.assertEquals("AB", convertToTitle(28));
    Assert.assertEquals("AA", convertToTitle(27));
    Assert.assertEquals("AY", convertToTitle(51));
    Assert.assertEquals("AZ", convertToTitle(52));
  }
}
