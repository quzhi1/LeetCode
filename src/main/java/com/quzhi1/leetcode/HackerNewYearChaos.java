package com.quzhi1.leetcode;

public class HackerNewYearChaos {

  // Use System out to print answer
  static void minimumBribes(int[] q) {
    int distance = 0;
    for (int i = 0; i < q.length; i++) {
      if (q[i] > i + 3) {
        System.out.println("Too chaotic");
        return;
      }
      // Bubble
      for (int j = i - 1; j > -1 && q[i] < i + 1; j--) {
//        System.out.println("Swapping " + q[i] + " and " + q[j]);
        int temp = q[j];
        q[j] = q[i];
        q[i] = temp;
        i = j - 1;
        distance++;
      }
    }
    System.out.println(distance);
  }

  public static void main(String[] args) {
    minimumBribes(new int[]{2, 1, 5, 3, 4}); // 3
    minimumBribes(new int[]{2, 5, 1, 3, 4}); // Too chaotic
    minimumBribes(new int[]{5, 1, 2, 3, 7, 8, 6, 4}); // Too chaotic
    minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4}); // 7

  }
}
