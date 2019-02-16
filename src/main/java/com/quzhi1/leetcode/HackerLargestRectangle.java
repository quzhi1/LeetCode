package com.quzhi1.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class HackerLargestRectangle {

  static long largestRectangleN2(int[] h) {
    Set<Integer> hSet = heightSet(h);
    int max = 0;
    for (Integer bar : hSet) {
      int start = -1;
      for (int i = 0; i < h.length; i++) {
        if (start == -1 && h[i] >= bar) {
          start = i;
        } else if (start != -1 && h[i] < bar) {
//          System.out.println("[" + start + ", " + i + "]: ");
          max = Math.max(max, bar * (i - start));
          start = -1;
        }
      }
      if (start != -1) {
        max = Math.max(max, bar * (h.length - start));
      }
    }
    return max;
  }

  private static Set<Integer> heightSet(int[] h) {
    Set<Integer> heightSet = new HashSet<>();
    for (int height : h) {
      heightSet.add(height);
    }
    return heightSet;
  }

  // Modified from
  // https://github.com/mission-peace/interview/blob/master/src/com/interview/stackqueue/MaximumHistogram.java
  static long largestRectangle(int[] h) {
    Stack<Integer> stack = new Stack<>();
    int max = 0;
    int i = 0;
    while (i < h.length) {
      if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
        stack.push(i++);
      } else {
        int top = stack.pop();
        //if stack is empty means everything till i has to be
        //greater or equal to input[top] so get area by
        //input[top] * i;
        if (stack.isEmpty()) {
          max = Math.max(max, h[top] * i);
        }
        //if stack is not empty then everythin from i-1 to stack.peek() + 1
        //has to be greater or equal to input[top]
        //so area = input[top]*(i - stack.peek() - 1);
        else {
          max = Math.max(max, h[top] * (i - stack.peek() - 1));
        }
      }
    }
    while (!stack.isEmpty()) {
      int top = stack.pop();
      //if stack is empty means everything till i has to be
      //greater or equal to input[top] so get area by
      //input[top] * i;
      if (stack.isEmpty()) {
        max = Math.max(max, h[top] * i);
      }
      //if stack is not empty then everything from i-1 to stack.peek() + 1
      //has to be greater or equal to input[top]
      //so area = input[top]*(i - stack.peek() - 1);
      else {
        max = Math.max(max, h[top] * (i - stack.peek() - 1));
      }
    }
    return max;
  }

  public static void main(String[] args) {
//    System.out.println(largestRectangle(new int[]{5, 1, 6})); // 6
//    System.out.println(largestRectangle(new int[]{1, 2, 3, 4, 5})); // 9
    System.out.println(largestRectangle(new int[]{1, 2, 3, 4, 5, 3, 3, 2})); // 15
//    System.out.println(largestRectangle(new int[]{8979, 4570, 6436, 5083, 7780, 3269, 5400,
//        7579, 2324, 2116})); // 26152

  }

}
