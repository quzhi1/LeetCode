package com.quzhi1.leetcode;

import java.util.Stack;
import org.junit.Assert;

public class Leet13 {

  enum RomeNum {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    int value;

    RomeNum(int value) {
      this.value = value;
    }

    static RomeNum fromChar(char c) {
      switch (c) {
        case 'I':
          return I;
        case 'V':
          return V;
        case 'X':
          return X;
        case 'L':
          return L;
        case 'C':
          return C;
        case 'D':
          return D;
        case 'M':
          return M;
        default:
          throw new IllegalArgumentException("Unrecognized roman char");
      }
    }

    int getValue() {
      return value;
    }
  }

  public static int romanToInt(String romanStr) {
    if (romanStr == null || romanStr.isEmpty()) {
      return 0;
    }
    Stack<Integer> stack = new Stack<>();
    for (char digit : romanStr.toCharArray()) {
      if (stack.isEmpty()) {
        stack.push(RomeNum.fromChar(digit).getValue());
      } else {
        int top = stack.peek();
        int target = RomeNum.fromChar(digit).getValue();
        if (target > top) {
          stack.push(target - stack.pop());
        } else {
          stack.push(target);
        }
      }
    }
    int result = 0;
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    return result;
  }

  public static void main(String[] args) {
    Assert.assertEquals(3, romanToInt("III"));
    Assert.assertEquals(4, romanToInt("IV"));
    Assert.assertEquals(9, romanToInt("IX"));
    Assert.assertEquals(58, romanToInt("LVIII"));
    Assert.assertEquals(1994, romanToInt("MCMXCIV"));
  }
}
