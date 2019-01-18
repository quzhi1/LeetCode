package com.quzhi1.leetcode;

import java.util.Arrays;

public class Leet34 {

  public static int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[]{-1, -1};
    }
    int[] result = search(nums, target, 0, nums.length);
    if (result[1] != -1) {
      result[1]--;
    }
    return result;
  }

  private static int[] search(int[] nums, int target, int leftMost, int rightMost) {
//    System.out.println("left: " + leftMost + ", right: " + rightMost);
    if (leftMost == rightMost - 1) {
      if (nums[leftMost] == target) {
        return new int[]{leftMost, rightMost};
      } else {
        return new int[]{-1, -1};
      }
    } else {
      int[] subNums = Arrays.copyOfRange(nums, leftMost, rightMost);
      int mid = subNums.length / 2;
      if (subNums[mid] > target) {
        return search(nums, target, leftMost, rightMost - mid);
      } else if (subNums[mid] < target) {
        return search(nums, target, leftMost + mid, rightMost);
      } else {
        int[] left = search(nums, target, leftMost, rightMost - mid);
        int[] right = search(nums, target, leftMost + mid, rightMost);
        if (Arrays.equals(left, new int[]{-1, -1}) && Arrays.equals(right, new int[]{-1, -1})) {
          return new int[] {-1, -1};
        } else if (Arrays.equals(left, new int[]{-1, -1})) {
          return right;
        } else if (Arrays.equals(right, new int[]{-1, -1})) {
          return left;
        } else {
          return new int[] {left[0], right[1]};
        }
      }
    }
  }

  public static void main(String[] main) {
    Arrays.stream(searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8))
        .forEach(element -> System.out.print(element + ", "));
    System.out.println();
    Arrays.stream(searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6))
        .forEach(element -> System.out.print(element + ", "));
    System.out.println();
    Arrays.stream(searchRange(new int[] {}, 6))
        .forEach(element -> System.out.print(element + ", "));
  }
}
