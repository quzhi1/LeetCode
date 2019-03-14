package com.quzhi1.leetcode;

import java.util.PriorityQueue;
import org.junit.Assert;

public class HackerGreedyFlorist {

  static int getMinimumCost(int k, int[] c) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(c.length, (i1, i2) -> i2 - i1);
    for (int flower : c) {
      pq.add(flower);
    }
    int result = 0;
    int rounds = 1;
    while (!pq.isEmpty()) {
      for (int i = 0; i < k && !pq.isEmpty(); i++) {
        result += rounds * pq.poll();
      }
      rounds++;
    }
    return result;
  }

  public static void main(String[] args) {
    Assert.assertEquals(13, getMinimumCost(3, new int[]{2, 5, 6}));
    Assert.assertEquals(15, getMinimumCost(2, new int[]{2, 5, 6}));
    Assert.assertEquals(29, getMinimumCost(3, new int[]{1, 3, 5, 7, 9}));
  }
}
