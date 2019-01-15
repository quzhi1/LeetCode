package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Leet46 {

  public static List<List<Integer>> permute(int[] nums) {
    if (nums.length == 0) {
      return Collections.emptyList();
    } else if (nums.length == 1) {
      return Collections.singletonList(Collections.singletonList(nums[0]));
    } else if (nums.length == 2) {
      return Arrays.asList(Arrays.asList(nums[0], nums[1]), Arrays.asList(nums[1], nums[0]));
    } else {
      List<List<Integer>> result = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
        List<Integer> rest = Arrays.stream(nums).boxed().collect(Collectors.toList());
        rest.remove((int) i);
        int[] restArray = rest.stream().mapToInt(Integer::intValue).toArray();
        List<List<Integer>> partialResult = permute(restArray);
        for (List<Integer> arrangement : partialResult) {
          List<Integer> newArrangement = new ArrayList<>(arrangement);
          newArrangement.add(nums[i]);
          result.add(newArrangement);
        }
      }
      return result;
    }
  }

  public static void main(String[] args) {
    int[] input1 = {1, 2, 3};
    List<List<Integer>> result1 = permute(input1);

    // Print
    for (List<Integer> arrangement : result1) {
      arrangement.forEach(integer -> System.out.print(integer + ","));
      System.out.println();
    }
  }

}
