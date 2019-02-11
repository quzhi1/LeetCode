package com.quzhi1.leetcode;

import java.util.EmptyStackException;
import java.util.Stack;

public class HackerBalancedBrackets {

  static String isBalanced(String s) {
    try {
      Stack<Character> stack = new Stack<>();
      for (char c : s.toCharArray()) {
        switch (c) {
          case '(':
          case '[':
          case '{':
            stack.push(c);
            break;
          case ')':
            if (stack.pop() != '(') {
              return "NO";
            }
            break;
          case ']':
            if (stack.pop() != '[') {
              return "NO";
            }
            break;
          case '}':
            if (stack.pop() != '{') {
              return "NO";
            }
            break;
        }
      }
      return stack.isEmpty() ? "YES" : "NO";
    } catch (EmptyStackException e) {
      return "NO";
    }
  }

  public static void main(String[] args) {
//    System.out.println(isBalanced("{[()]}")); // YES
//    System.out.println(isBalanced("{[(])}")); // NO
//    System.out.println(isBalanced("{{[[(())]]}}")); // YES
    System.out.println(isBalanced("}][}}(}][))]")); // NO
    System.out.println(isBalanced("[](){()}")); // YES
    System.out.println(isBalanced("()")); // YES
    System.out.println(isBalanced("({}([][]))[]()")); // YES
    System.out.println(isBalanced("{)[](}]}]}))}(())(")); // NO
    System.out.println(isBalanced("([[)")); // NO
  }

}
