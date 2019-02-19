package com.quzhi1.leetcode;

import org.junit.Assert;

public class Leet44 {

  static boolean isMatch(String str, String pattern) {
    int s = 0, p = 0, lookAheadS = 0, lastStar = -1;
    //遍历整个字符串
    while (s < str.length()) {
      // 一对一匹配，两指针同时后移。
      if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
        s++;
        p++;
      }
      // 碰到 *，假设它匹配空串，并且用 lastStar 记录 * 的位置，记录当前字符串的位置，p 后移
      else if (p < pattern.length() && pattern.charAt(p) == '*') {
        lastStar = p;
        lookAheadS = s;
        p++;
      }
      // 当前字符不匹配，并且也没有 *，回退
      // p 回到 * 的下一个位置
      // match 更新到下一个位置
      // s 回到更新后的 match
      // 这步代表用 * 匹配了一个字符
      else if (lastStar != -1) {
        p = lastStar + 1;
        lookAheadS++;
        s = lookAheadS;
      }
      //字符不匹配，也没有 *，返回 false
      else {
        return false;
      }
    }

    //将末尾多余的 * 直接匹配空串 例如 text = ab, pattern = a*******
    while (p < pattern.length() && pattern.charAt(p) == '*') {
      p++;
    }

    return p == pattern.length();
  }

  public static void main(String[] args) {
    Assert.assertTrue(isMatch("", "*"));
    Assert.assertTrue(isMatch("a", "a*"));
    Assert.assertFalse(isMatch("a", ""));
    Assert.assertFalse(isMatch("aa", "a"));
    Assert.assertTrue(isMatch("aa", "*"));
    Assert.assertFalse(isMatch("cb", "?a"));
    Assert.assertTrue(isMatch("adceb", "*a*b"));
    Assert.assertFalse(isMatch("acdcb", "a*c?b"));
    Assert.assertTrue(isMatch("ringinga", "r*inga"));
    Assert.assertTrue(isMatch("ringing", "r*ing"));
    Assert.assertFalse(isMatch("mississippi", "m??*ss*?i*pi"));
    Assert.assertFalse(isMatch("bcd", "??"));
    Assert.assertTrue(isMatch("c", "*?*"));
    Assert.assertTrue(isMatch("hi", "*?"));
    Assert.assertFalse(isMatch("b", "*a"));
    Assert.assertTrue(isMatch("aaaa", "***a"));
    Assert.assertTrue(isMatch(
        "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
        "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
  }

}
