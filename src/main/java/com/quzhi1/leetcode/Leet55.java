package com.quzhi1.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leet55 {

  public static boolean canJump(int[] nums) {
    Set<Integer> indexPossible = new HashSet<>();
    indexPossible.add(nums.length - 1);
    for (int i = nums.length - 1; i > -1; i--) {
      if (nums[i] + i >= nums.length) {
        indexPossible.add(i);
      } else {
        for (int j = i; j <= nums[i] + i; j++) {
          if (indexPossible.contains(j)) {
            indexPossible.add(i);
          }
        }
      }
    }
    return indexPossible.contains(0);
  }

  public static void main(String[] main) {
    System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
  }

}
