package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Leet78 {

  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
    subsetPermute(numList, result);
    return result;
  }

  private static void subsetPermute(List<Integer> nums, List<List<Integer>> partialResult) {
    if (nums.isEmpty()) {
      return;
    } else if (nums.size() == 1) {
      partialResult.add(Collections.singletonList(nums.get(0)));
      partialResult.add(Collections.emptyList());
    } else {
      subsetPermute(nums.subList(1, nums.size()), partialResult);
      List<List<Integer>> newSubsets = partialResult.stream()
          .map(eachPartialResult -> {
            List<Integer> newPartialResult = new ArrayList<>(eachPartialResult);
            newPartialResult.add(nums.get(0));
            return newPartialResult;
          })
          .collect(Collectors.toList());
      partialResult.addAll(newSubsets);
    }
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3};
    List<List<Integer>> result1 = subsets(nums1);
    result1.forEach(eachSubset -> {
      eachSubset.forEach(System.out::print);
      System.out.println();
    });
  }

}
