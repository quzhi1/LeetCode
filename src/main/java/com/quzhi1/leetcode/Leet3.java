package com.quzhi1.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leet3 {

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> charSet = new HashSet<>();
        while (left <= right && right < s.length()) {
            char moreChar = s.charAt(right);
            // log
//            System.out.println("moreChar: " + moreChar);
            //
            if (charSet.contains(moreChar)) {
                charSet.remove(s.charAt(left));
                left++;
            } else {
                // log
//                System.out.println("Found: " + s.substring(left, right));
                //
                if (right - left + 1 > max) {
                    max = right - left + 1;
                }
                charSet.add(moreChar);
                right++;
            }
        }
        if (max == 0) {
            return s.length();
        } else {
            return max;
        }
    }

    public static void main(String[] args) {
        String input1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(input1));
        String input2 = "abc";
        System.out.println(lengthOfLongestSubstring(input2));
        String input3 = "aab";
        System.out.println(lengthOfLongestSubstring(input3));
        String input4 = "dvdf";
        System.out.println(lengthOfLongestSubstring(input4));
        String input5 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(input5));
        String input6 = "bbbb";
        System.out.println(lengthOfLongestSubstring(input6));
    }
}
