package com.quzhi1.leetcode;

public class HackerMinimumSwaps2 {

  static int minimumSwaps(int[] arr) {
    int numSwap = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != i + 1) {
        int target = arr[i] - 1;
        int temp = arr[target];
        arr[target] = arr[i];
        arr[i] = temp;
        i--;
        numSwap++;
      }
    }
    return numSwap;
  }

  public static void main(String[] args) {
    System.out.println(minimumSwaps(new int[]{2, 3, 4, 1, 5})); // 3
    System.out.println(minimumSwaps(new int[]{4, 3, 1, 2})); // 3
  }
}
