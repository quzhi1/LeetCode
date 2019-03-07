package com.quzhi1.leetcode;

import org.junit.Assert;

public class HackerCommonChild {

  static int commonChild(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
      return 0;
    }
    char[] charArr1 = s1.toCharArray();
    char[] charArr2 = s2.toCharArray();
    int[][] m = new int[s2.length() + 1][s1.length() + 1];

    // First row and col should be 0
    for (int j = 0; j < s1.length() + 1; j++) {
      m[0][j] = 0;
    }
    for (int i = 0; i < s2.length() + 1; i++) {
      m[i][0] = 0;
    }

    // DP
    for (int i = 1; i < s2.length() + 1; i++) {
      for (int j = 1; j < s1.length() + 1; j++) {
        if (charArr1[j - 1] == charArr2[i - 1]) {
          m[i][j] = m[i - 1][j - 1] + 1;
        } else {
          m[i][j] = Math.max(m[i - 1][j], m[i][j - 1]);
        }
      }
    }
//    printMatrix(m, s1, s2);
    return m[s2.length()][s1.length()];
  }

  private static void printMatrix(int[][] m, String s1, String s2) {
    System.out.print(" ");
    for (int i = 0; i < s1.length(); i++) {
      System.out.print("\t" + s1.toCharArray()[i]);
    }
    System.out.println();
    for (int i = 1; i < s2.length() + 1; i++) {
      System.out.print(s2.toCharArray()[i - 1]);
      for (int j = 1; j < s1.length() + 1; j++) {
        System.out.print("\t" + m[i][j]);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
//    Assert.assertEquals(3, commonChild("ABCD", "ABDC"));
//    Assert.assertEquals(2, commonChild("HARRY", "SALLY"));
//    Assert.assertEquals(0, commonChild("AA", "BB"));
//    Assert.assertEquals(3, commonChild("SHINCHAN", "NOHARAAA"));
//    Assert.assertEquals(2, commonChild("ABCDEF", "FBDAMN"));
//    Assert.assertEquals(2, commonChild("OUDFRMYMAW", "AWHYFCCMQX"));
//    Assert.assertEquals(15, commonChild("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS",
//        "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC"));
//    Assert.assertEquals(3, commonChild("ABCD", "AABC"));
//    Assert.assertEquals(2, commonChild("ABCD", "AEAB"));
//    Assert.assertEquals(1, commonChild("ABCD", "DCBA"));
//    Assert.assertEquals(4, commonChild("AAAAA", "AAABA"));
    Assert.assertEquals(4, commonChild("abcdaf", "acbcf"));
  }
}
