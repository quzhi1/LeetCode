package com.quzhi1.leetcode;

public class Leet713 {

  // Sliding window
  // The point is, iterate base on right index
  // And the optimization is: maintaining "product"
  public static int numSubarrayProductLessThanK(int[] nums, int k) {
    int counter = 0;
    int left = 0;
    int product = 1;
    for (int j = 0; j < nums.length; j++) {
      product *= nums[j];
      int i = left;
      for (; i <= j; i++) {
        if (product >= k) {
          product /= nums[i];
        } else {
          break;
        }
      }
      left = i;
      counter += j - left + 1;
      // test
//            System.out.println("left: " + left + ", right: " + j + ", product: " + product);
      //
    }
    return counter;
  }

  public static void main(String[] args) {
    int[] nums1 = {10, 5, 2, 6};
    int k1 = 100;
    System.out.println(numSubarrayProductLessThanK(nums1, k1));
    int[] nums2 = {1, 2, 3};
    int k2 = 0;
    System.out.println(numSubarrayProductLessThanK(nums2, k2));
  }
}
