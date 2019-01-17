package com.quzhi1.leetcode;

import java.util.Arrays;

public class Leet75 {

  public static void sortColors(int[] nums) {
    int left = 0, right = nums.length - 1;
    Arrays.stream(nums).forEach(num -> System.out.print(num + ","));
    System.out.println();
    for (int i = 0; i <= right; i++) {
      if (nums[i] == 0) {
        nums[i] = nums[left];
        nums[left] = 0;
        left++;
      } else if (nums[i] == 2) {
        nums[i] = nums[right];
        i--;
        nums[right] = 2;
        right--;
      }
    }
  }

  public static void main(final String[] args) {
    int[] nums = {2,0,1};
    sortColors(nums);
    Arrays.stream(nums).forEach(num -> System.out.print(num + ","));
    System.out.println();
  }

}
