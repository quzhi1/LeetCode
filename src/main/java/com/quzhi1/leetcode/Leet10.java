package com.quzhi1.leetcode;

import org.junit.Assert;

public class Leet10 {

  public static boolean isMatch(String s, String p) {
    if (p.length() == 0) {
      return s.length() == 0;
    } else if (p.length() == 1) {
      if (s.length() == 1 && isFirstCharMatch(s, p)) {
        return true;
      } else {
        return false;
      }
    } else {
      if (p.charAt(1) == '*') {
        while (s.length() > 0 && isFirstCharMatch(s, p)) {
          if (isMatch(s, p.substring(2))) { // for example, a* eats aaa or .* eats abc.
            return true;
          }
          s = s.substring(1);
        }
        return isMatch(s, p.substring(2));
      } else {
        if (s.length() > 0 && isFirstCharMatch(s, p)) {
          return isMatch(s.substring(1), p.substring(1));
        } else {
          return false;
        }
      }
    }
  }

  private static boolean isFirstCharMatch(String s, String p) {
    return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
  }

  public static void main(String[] args) {
    Assert.assertTrue(isMatch("mississippi", "mis*is*ip*."));
  }
}
