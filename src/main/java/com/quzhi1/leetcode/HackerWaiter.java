package com.quzhi1.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import org.junit.Assert;

public class HackerWaiter {

  static int[] waiter(int[] number, int q) {
    // Init
    Stack<Integer> aStack = new Stack<>();
    for (int a: number) {
      aStack.push(a);
    }
    Queue<Stack<Integer>> bStackQueue = new LinkedList<>();

    // Process
    int prime = 1;
    for (int i = 0; i < q; i++) {
      prime = nextPrime(prime);
      Stack<Integer> bStack = new Stack<>();
      Stack<Integer> newAStack = new Stack<>();
      while (!aStack.isEmpty()) {
        int top = aStack.pop();
        if (top % prime == 0) {
          bStack.push(top);
        } else {
          newAStack.push(top);
        }
      }
      aStack = newAStack;
      bStackQueue.offer(bStack);
    }

    // dump B then A
    int[] result = new int[number.length];
    int i = 0;
    while (!bStackQueue.isEmpty()) {
      Stack<Integer> bStack = bStackQueue.poll();
      while (!bStack.isEmpty()) {
        result[i++] = bStack.pop();
      }
    }
    while (!aStack.isEmpty()) {
      result[i++] = aStack.pop();
    }
    return result;
  }

  private static int nextPrime(final int input) {
    int start = input + 1;
    while (!isPrime(start)) {
      start++;
    }
    return start;
  }

  private static boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }
    if (n <= 3) {
      return true;
    }
    if (n % 2 == 0 || n % 3 == 0) {
      return false;
    }
    for (int i = 5; i * i <= n; i = i + 6) {
      if (n % i == 0 || n % (i + 2) == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Assert.assertArrayEquals(new int[]{4, 6, 3, 7, 5}, waiter(new int[]{3, 4, 7, 6, 5}, 1));
    Assert.assertArrayEquals(new int[]{4, 4, 9, 3, 3}, waiter(new int[]{3, 3, 4, 4, 9}, 2));
//    int prime = 1;
//    for (int i = 0; i < 20; i++) {
//      prime = nextPrime(prime);
//      System.out.println(prime);
//    }
  }
}
