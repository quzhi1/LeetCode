package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;

public class HackerCountTriplets {

  static long countTriplets(List<Long> arr, long r) {
    if (arr.size() < 3) {
      return 0;
    }
    Map<Long, Long> leftMap = new HashMap<>();
    Map<Long, Long> rightMap = new HashMap<>();
    leftMap.put(arr.get(0), 1L);
    for (int i = 2; i < arr.size(); i++) {
      rightMap.merge(arr.get(i), 1L, (i1, i2) -> i1 + 1);
    }
    long result = 0;
    for (int i = 1; i < arr.size() - 1; i++) {
      if (arr.get(i) % r == 0 && leftMap.containsKey(arr.get(i) / r) && rightMap.containsKey(arr.get(i) * r)) {
        result += leftMap.get(arr.get(i) / r) * rightMap.get(arr.get(i) * r);
      }
      leftMap.merge(arr.get(i), 1L, (i1, i2) -> i1 + 1);
      long next = arr.get(i + 1);
      rightMap.put(next, rightMap.get(next) - 1);
    }
    return result;
  }

  public static void main(String[] args) {
    Assert.assertEquals(2, countTriplets(Arrays.asList(1L, 2L, 2L, 4L), 2));
    Assert.assertEquals(6, countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3));
    Assert.assertEquals(4, countTriplets(Arrays.asList(1L, 5L, 5L, 25L, 125L), 5));
    Assert.assertEquals(3, countTriplets(Arrays.asList(1L, 2L, 1L, 2L, 4L), 2));
    Assert.assertEquals(20, countTriplets(Arrays.asList(1L, 1L, 1L, 1L, 1L, 1L, 2L, 4L), 1));
    Assert.assertEquals(166661666700000L, countTriplets(new ArrayList<>(Collections.nCopies(100000, 1237L)), 1));
  }
}
