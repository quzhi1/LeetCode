package com.quzhi1.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leet215 {

  public static int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
    Arrays.stream(nums).forEach(num -> {
      heap.add(num);
      if (heap.size() > k) {
        heap.poll();
      }
    });
    return heap.poll();
  }

  public static void main(final String[] args) {
    int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    System.out.println(findKthLargest(nums, 4));
  }

}
