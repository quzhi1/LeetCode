package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (sumMap.get(nums[i]) != null && sumMap.get(nums[i]) != i) {
                int result[] = new int[2];
                result[0] = i;
                result[1] = sumMap.get(nums[i]);
                return result;
            } else {
                sumMap.put(target - nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 0;
        int[] result = twoSum(nums, target);
        if (result != null) {
            System.out.println(result[0]);
            System.out.println(result[1]);
        } else {
            System.out.println("Failed");
        }
    }
}
