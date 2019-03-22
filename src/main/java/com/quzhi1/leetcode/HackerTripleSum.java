package com.quzhi1.leetcode;

import java.util.Arrays;
import org.junit.Assert;

public class HackerTripleSum {

  static long triplets(int[] a, int[] b, int[] c) {
    a = Arrays.stream(a).sorted().distinct().toArray();
    b = Arrays.stream(b).sorted().distinct().toArray();
    c = Arrays.stream(c).sorted().distinct().toArray();
    long result = 0;
    int left = 0;
    int right = 0;
    for (int eachB : b) {
      for (int j = left; j < a.length && a[j] <= eachB; j++) {
        left++;
      }
      for (int j = right; j < c.length && c[j] <= eachB; j++) {
        right++;
      }
//      System.out.println(eachB + ": " + left + " * " + right + " = " + left * right);
      result += (long) left * right;
    }
    return result;
  }

  public static void main(String[] args) {
//    Assert.assertEquals(8, triplets(new int[]{1, 3, 5}, new int[]{2, 3}, new int[]{1, 2, 3}));
    Assert.assertEquals(5, triplets(new int[]{1, 4, 5}, new int[]{2, 3, 3}, new int[]{1, 2, 3}));
  }

}
