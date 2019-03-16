package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;

public class Leet829SpaceExceed {

  /*
  dp matrix:

    0 1 2 3 4 5  6  7
  0 0 0 0 0 0 0  0  0
  1 0 0 1 3 6 10 15 21
  2 0 0 0 2 5 9  14 20 ...
  3 ...
  4
  5
  6
  7
  * */

  private static int CAP = 0;
  private static final Map<Integer, Integer> result = new HashMap<>();
  private static final int[][] sums = new int[10000][10000];

  public static int consecutiveNumbersSum(int num) {
    if (num + 1 > CAP) {
      for (int i = CAP; i < num + 2; i++) {
        for (int j = CAP; j < num + 2; j++) {
          if (i > 0 && j > i) {
            sums[i][j] = sums[i][j - 1] + j - 1;
            result.merge(sums[i][j], 1, (i1, i2) -> i1 + 1);
          }
        }
      }
      CAP = num + 1;
    }
    return result.get(num);
  }

  public static void main(String[] args) {
    Assert.assertEquals(3, consecutiveNumbersSum(15));
    Assert.assertEquals(1, consecutiveNumbersSum(10));
  }

}
