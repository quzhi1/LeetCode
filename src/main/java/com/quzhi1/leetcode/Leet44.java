package com.quzhi1.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Leet44 {

  public static boolean isMatch(String s, String p) {
    p = p.replaceAll("\\?", ".");
    p = starConversion(p);
//    System.out.println("pattern: " + p);
    Pattern pattern = Pattern.compile(p);
    Matcher matcher = pattern.matcher(s);
    return matcher.matches();
  }

  private static String starConversion(final String p) {
    boolean hasStar = false;
    StringBuilder sb = new StringBuilder();
    for (char eachChar : p.toCharArray()) {
      if (eachChar == '*' && !hasStar) {
        sb.append(".*");
        hasStar = true;
      } else if (eachChar != '*') {
        sb.append(eachChar);
        hasStar = false;
      }
    }
    return sb.toString();
  }

    public static void main(String[] args) {
    System.out.println(isMatch("aa", "a")); // false
    System.out.println(isMatch("aa", "*")); // true
    System.out.println(isMatch("cb", "?a")); // false
    System.out.println(isMatch("adceb", "*a*b")); // true
    System.out.println(isMatch("acdcb", "a*c?b")); // false
    System.out.println(isMatch(
        "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
        "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*")); // true
    System.out.println(isMatch("mississippi", "m??*ss*?i*pi")); // false
  }

}
