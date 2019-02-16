package com.quzhi1.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class HackerGameOfTwoStacks {

  private static int twoStacks(int x, int[] a, int[] b) {
    Stack<Integer> aS = new Stack<>();
    Stack<Integer> bS = new Stack<>();
    a = cleanDeck(x, a);
    b = cleanDeck(x, b);
    for (int i = a.length - 1; i > -1; i--) {
      aS.push(a[i]);
    }
    for (int i = b.length - 1; i > -1; i--) {
      bS.push(b[i]);
    }
    return twoStacksStack(x, aS, bS);
  }

  private static int[] cleanDeck(int x, int[] d) {
    if (d.length == 0) {
      return d;
    }
    int i = 0;
    int sum = 0;
    for (; i < d.length; i++) {
      sum += d[i];
      if (sum > x) {
        break;
      }
    }
    return Arrays.copyOfRange(d, 0, i);
  }

  private static int popA(int x, Stack<Integer> a, Stack<Integer> b) {
    int aHead = a.pop();
//    System.out.println("Pop " + aHead);
    int result = 1 + twoStacksStack(x - aHead, a, b);
    a.push(aHead);
    return result;
  }

  private static int popB(int x, Stack<Integer> a, Stack<Integer> b) {
    int bHead = b.pop();
//    System.out.println("Pop " + bHead);
    int result = 1 + twoStacksStack(x - bHead, a, b);
    b.push(bHead);
    return result;
  }

  private static boolean canPop(int x, Stack<Integer> s) {
    return !s.isEmpty() && s.peek() <= x;
  }

  private static int twoStacksStack(int x, Stack<Integer> a, Stack<Integer> b) {
//    if (x <= 0) {
//      return 0;
//    }
    if (!canPop(x, a) && !canPop(x, b)) {
//      System.out.println("Found solution");
      return 0;
    } else if (!canPop(x, a)) {
      return popB(x, a, b);
    } else if (!canPop(x, b)) {
      return popA(x, a, b);
    } else {
      return Math.max(popA(x, a, b), popB(x, a, b));
    }
  }

  public static void main(String[] args) {
//    System.out.println(twoStacks(2, new int[]{1}, new int[]{1})); // 2
//    System.out.println(twoStacks(4, new int[]{2}, new int[]{1, 1})); // 3
//    System.out.println(twoStacks(6, new int[]{2, 2}, new int[]{1, 1})); // 4
    System.out.println(twoStacks(10, new int[]{4, 2, 4, 6, 1}, new int[]{2, 1, 8, 5})); // 4
  }
}
