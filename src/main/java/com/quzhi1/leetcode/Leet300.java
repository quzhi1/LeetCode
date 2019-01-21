package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leet300 {

  public static int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    List<Integer> longest = new ArrayList<>();
    longest.add(1);
    for (int i = 1; i < nums.length; i++) {
      int longestLength = 0;
      for (int j = 0; j < longest.size(); j++) {
        // Force the last element into increasing sub array (strange)
        if (nums[i] > nums[j]) {
          longestLength = Math.max(longest.get(j), longestLength);
        }
      }
      longest.add(longestLength + 1);
      Arrays.stream(Arrays.copyOfRange(nums, 0, longest.size())).forEach(num -> System.out.print(num + ", "));
      System.out.println("->" + longest.get(longest.size() - 1));
    }
    return Collections.max(longest);
  }

  public static void main(String[] main) {
//    System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));  // 4
    System.out.println(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));  // 6
  }

}
