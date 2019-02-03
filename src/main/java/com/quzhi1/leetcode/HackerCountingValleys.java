package com.quzhi1.leetcode;

public class HackerCountingValleys {

  static int countingValleys(int n, String s) {
    int valleyCount = 0;
    int level = 0;
    for (char step : s.toCharArray()) {
      if (step == 'U') {
        level++;
        if (level == 0) {
          valleyCount++;
        }
      } else {
        level--;
      }
    }
    return valleyCount;
  }

  public static void main(String[] args) {
    System.out.println(countingValleys(8, "DDUUUUDD")); // 1
    System.out.println(countingValleys(8, "UDDDUDUU")); // 1
    System.out.println(countingValleys(8, "DDUUDDUU")); // 2
  }
}
