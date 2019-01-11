package com.quzhi1.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leet334 {

  public static boolean increasingTriplet(int[] nums) {
    if (nums == null || nums.length < 3) {
      return false;
    }
    // Left heap, smallest first
    PriorityQueue<Integer> leftQueue = new PriorityQueue<>(1,
        Comparator.comparing(Integer::intValue));
    leftQueue.add(nums[0]);
    // Left heap, largest first
    PriorityQueue<Integer> rightQueue = new PriorityQueue<>(1,
        Comparator.comparing(Integer::intValue).reversed());
    for (int i = 2; i < nums.length; i++) {
      rightQueue.add(nums[i]);
    }
    for (int center = 1; center < nums.length - 1; center++) {
      int leftMin = leftQueue.peek();
      int rightMax = rightQueue.peek();
      // log
//            System.out.println("center: " + nums[center] + ", leftMin: " + leftMin + ", rightMax: " + rightMax);
      //
      if (leftMin < nums[center] && rightMax > nums[center]) {
        return true;
      } else {
        leftQueue.add(nums[center]);
        rightQueue.remove(nums[center + 1]);
      }
    }
    return false;
  }

  public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 4, 5};
//        System.out.println(increasingTriplet(nums1));
//        int[] nums2 = {5, 4, 3, 2, 1};
//        System.out.println(increasingTriplet(nums2));
    int[] nums3 = {0, 4, 2, 1, 0, -1, -3};
    System.out.println(increasingTriplet(nums3));
  }
}
