package com.quzhi1.leetcode;

import java.util.Arrays;

public class Leet43 {

  public static String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    String result = "0";
    for (int i = num2.toCharArray().length - 1; i > -1; i--) {
      char[] zeros = new char[num2.toCharArray().length - i - 1];
      Arrays.fill(zeros, '0');
      String singleResult = multiplyOneMany(num1, num2.charAt(i)) + new String(zeros);
//      System.out.println("singleResult: " + singleResult);
      result = addNum(result, singleResult);
    }
    return result;
  }

  private static String multiplyOneMany(String num1, char num2) {
    if (num2 == '0') {
      return "0";
    }
    int carry = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = num1.toCharArray().length - 1; i > -1; i--) {
      int result = multiplyOneOne(num1.charAt(i), num2, carry);
      sb.append(result % 10);
      carry = result / 10;
    }
    if (carry > 0) {
      sb.append(carry);
    }
    return sb.reverse().toString();
  }

  private static String addNum(String num1, String num2) {
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

  private static int multiplyOneOne(char num1, char num2, int carry) {
    return Character.getNumericValue(num1) * Character.getNumericValue(num2) + carry;
  }

  public static void main(String[] args) {
//    System.out.println(multiply("2", "3"));
//    System.out.println(multiply("123", "456"));
//    System.out.println(multiply("9124", "0"));
    System.out.println(multiply("0", "52"));
  }

}
