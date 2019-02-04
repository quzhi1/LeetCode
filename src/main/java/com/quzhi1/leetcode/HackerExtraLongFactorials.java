package com.quzhi1.leetcode;

import java.math.BigInteger;

public class HackerExtraLongFactorials {

  static void extraLongFactorials(int n) {
    BigInteger result = factorialBigInt(new BigInteger(Integer.toString(n)));
    System.out.println(result);
  }

  private static BigInteger factorialBigInt(final BigInteger n) {
    if (n.equals(BigInteger.ZERO)) {
      return BigInteger.ONE;
    } else {
      return n.multiply(factorialBigInt(n.subtract(BigInteger.ONE)));
    }
  }

  public static void main(String[] args) {
    extraLongFactorials(122);
  }
}
