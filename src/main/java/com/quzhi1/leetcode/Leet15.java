package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class Leet15 {

    // Got ETL
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        for (int center = 1; center < nums.length - 1; center++) {
            for (int left = 0; left < center; left++) {
                int partialSum = nums[left] + nums[center];
                if (partialSum > 0) {
                    break;
                }
                for (int right = center + 1; right < nums.length; right++) {
                    int sum = nums[left] + nums[center] + nums[right];
                    if (sum > 0) {
                        break;
                    } else if (sum == 0) {
                        List<Integer> oneResult = Arrays.asList(nums[left], nums[center], nums[right]);
                        // For test
//                        System.out.println("Found result: " + StringUtils.join(
//                            oneResult.stream().
//                                map(String::valueOf)
//                                .collect(Collectors.toList()),
//                            ","
//                        ));
//                        System.out.println("Center: " + nums[center] +
//                                           ", left: " + nums[left] +
//                                           ", right: " + nums[right]);
                        //
                        result.add(oneResult);
                        break;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    // https://leetcode.com/problems/3sum/discuss/7399/Easiest-Java-Solution
    public static List<List<Integer>> threeSumCorrect(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;  // skip same result
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;  // skip same result
                    }
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(final String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        printResult(threeSum(nums1));
        int[] nums2 = {0, 0, 0};
        printResult(threeSum(nums2));
    }

    public static void printResult(final List<List<Integer>> result) {
        System.out.println("Solution");
        result.forEach(eachResult ->
                           System.out.println(
                               StringUtils.join(
                                   eachResult.stream().
                                       map(String::valueOf)
                                       .collect(Collectors.toList()),
                                   ","
                               )
                           )
        );
    }
}
