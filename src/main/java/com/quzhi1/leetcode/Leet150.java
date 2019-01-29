package com.quzhi1.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leet150 {

  public static int evalRPN(String[] tokens) {
    if (tokens != null && tokens.length == 1) {
      return Integer.parseInt(tokens[0]);
    } else if (tokens == null || tokens.length < 3) {
      throw new RuntimeException("Invalid");
    }
    Deque<Integer> stack = new ArrayDeque<>();
    for (String token : tokens) {
      if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
        int right = stack.pop();
        int left = stack.pop();
        stack.push(eval(token, left, right));
      } else {
        stack.push(Integer.parseInt(token));
      }
    }
    if (stack.size() != 1) {
      throw new RuntimeException("Invalid");
    } else {
      return stack.pop();
    }
  }

  private static int eval(String operator, int left, int right) {
    switch (operator) {
      case ("+"):
        return left + right;
      case ("-"):
        return left - right;
      case ("*"):
        return left * right;
      case ("/"):
        return left / right;
      default:
        throw new RuntimeException("Invalid");
    }
  }

  public static void main(String[] args) {
    System.out.println(evalRPN(new String[]{"18"})); // 18
    System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"})); // 9
    System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"})); // 6
    System.out
        .println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})); // 22
    System.out.println(evalRPN(new String[]{"2","1","+","3","*"})); // 9
  }
}
