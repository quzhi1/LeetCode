package com.quzhi1.leetcode;

public class Leet5 {

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }
        String max = "";
        for (int center = 0; center < s.length(); center++) {
            // odd
            int left = center;
            int right = center;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (right - left + 1 > max.length()) {
                        max = s.substring(left, right + 1);
                    }
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            // even
            left = center;
            right = center + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (right - left + 1 > max.length()) {
                        max = s.substring(left, right + 1);
                    }
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String input1 = "babad";
        System.out.println(longestPalindrome(input1));
        String input2 = "cbbd";
        System.out.println(longestPalindrome(input2));
    }
}
