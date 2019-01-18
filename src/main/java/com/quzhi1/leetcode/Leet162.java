package com.quzhi1.leetcode;

import java.util.Arrays;

public class Leet162 {

  public static int findPeakElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    } else if (nums.length == 1) {
      return 0;
    } else if (nums.length == 2) {
      return nums[0] > nums[1] ? 0 : 1;
    } else {
      int mid = nums.length / 2;
      if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
        return mid;
      } else {
        int[] left = Arrays.copyOfRange(nums, 0, mid + 1);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        int leftPeak = findPeakStrict(left);
        int rightPeak = findPeakStrict(right);
        if (leftPeak != -1) {
          return leftPeak;
        } else if (rightPeak != -1) {
          return mid + rightPeak;
        } else if (nums[0] > nums[1]) {
          return 0;
        } else if (nums[nums.length - 1] > nums[nums.length - 2]) {
          return nums.length - 1;
        } else {
          return -1;
        }
      }
    }
  }

  private static int findPeakStrict(int[] nums) {
    if (nums == null || nums.length == 0 || nums.length == 1 || nums.length == 2) {
      return -1;
    }
    int mid = nums.length / 2;
    if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
      return mid;
    } else {
      int[] left = Arrays.copyOfRange(nums, 0, mid + 1);
      int[] right = Arrays.copyOfRange(nums, mid, nums.length);
      int leftPeak = findPeakStrict(left);
      int rightPeak = findPeakStrict(right);
      if (leftPeak != -1) {
        return leftPeak;
      } else if (rightPeak != -1) {
        return mid + rightPeak;
      } else {
        return -1;
      }
    }
  }

  public static void main(String[] args) {
//    int[] input1 = {1, 2, 3, 1};
//    System.out.println(findPeakElement(input1));
//    int[] input2 = {1, 2, 1, 3, 5, 6, 4};
//    System.out.println(findPeakElement(input2));
    int[] input3 = {1, 2, 3, 4};
    System.out.println(findPeakElement(input3));
  }
}
