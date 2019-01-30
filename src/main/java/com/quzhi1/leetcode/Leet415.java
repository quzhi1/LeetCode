package com.quzhi1.leetcode;

import java.util.Arrays;

public class Leet415 {

  public static String addStrings(String num1, String num2) {
    String bigNum = num1.length() > num2.length() ? num1 : num2;
    String smallNum = num1.length() <= num2.length() ? num1 : num2;
    int digitDiff = bigNum.length() - smallNum.length();
    char[] zeros = new char[digitDiff];
    Arrays.fill(zeros, '0');
    String zerosStr = new String(zeros) + smallNum;
    smallNum = zerosStr + smallNum;
    int carry = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = bigNum.length() - 1; i > -1; i--) {
      int result = Character.getNumericValue(bigNum.charAt(i)) + Character.getNumericValue(smallNum.charAt(i)) + carry;
      sb.append(result % 10);
      carry = result / 10;
    }
    if (carry > 0) {
      sb.append(carry);
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(addStrings("111", "999"));
  }
}
