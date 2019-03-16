package com.quzhi1.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;

public class AirbnbTriangleOrNot {

  static String[] triangleOrNot(int[] a, int[] b, int[] c) {
    String[] result = new String[a.length];
    for (int i = 0; i < a.length; i++) {
      List<Integer> sortedList = Arrays.asList(a[i], b[i], c[i]);
      Collections.sort(sortedList);
      if (sortedList.get(2) < sortedList.get(0) + sortedList.get(1)) {
        result[i] = "Yes";
      } else {
        result[i] = "No";
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Assert.assertArrayEquals(new String[] {"No"}, triangleOrNot(new int[]{1}, new int[]{7}, new int[]{4}));
  }
}
