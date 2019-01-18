package com.quzhi1.leetcode;

import java.util.Arrays;

public class Leet33 {

  public static int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    } else if (nums.length == 1) {
      return nums[0] == target ? 0 : -1;
    }
    int[] splitLeft = Arrays.copyOfRange(nums, 0, nums.length / 2);
    int[] splitRight = Arrays.copyOfRange(nums, nums.length / 2, nums.length);
    int leftResult, rightResult;
    if (isSorted(splitLeft)) {
      leftResult = searchSorted(splitLeft, target);
      rightResult = search(splitRight, target) == -1 ? -1 : nums.length / 2 + search(splitRight, target);
    } else {
      leftResult = search(splitLeft, target);
      rightResult = searchSorted(splitRight, target) == -1 ? -1 : nums.length / 2 + searchSorted(splitRight, target);
    }
    if (leftResult != -1) {
      return leftResult;
    } else if (rightResult != -1) {
      return rightResult;
    } else {
      return -1;
    }
  }

  private static int searchSorted(int[] nums, int target) {
    int result = Arrays.binarySearch(nums, target);
    if (result < 0) {
      return -1;
    } else {
      return result;
    }
  }

  private static boolean isSorted(int[] nums) {
    if (nums.length <= 1) {
      return true;
    } else {
      return nums[0] < nums[nums.length - 1];
    }
  }

  public static void main(String[] args) {
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    System.out.println(search(nums, 0));
    System.out.println(search(nums, 3));
  }
}
