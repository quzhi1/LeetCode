package com.quzhi1.leetcode;

import java.util.PriorityQueue;
import org.junit.Assert;

public class Leet295 {

  static class MedianFinder {

    private final PriorityQueue<Integer> upperQueue = new PriorityQueue<>(Integer::compareTo);
    private final PriorityQueue<Integer> lowerQueue = new PriorityQueue<>((i1, i2) -> i2 - i1);

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
      upperQueue.add(Integer.MAX_VALUE / 2);
      lowerQueue.add(Integer.MIN_VALUE / 2);
    }

    public void addNum(int num) {
      int lowerMax = lowerQueue.peek();
      int upperMin = upperQueue.peek();
      if (num > upperMin) {
        upperQueue.add(num);
      } else if (num < lowerMax) {
        lowerQueue.add(num);
      } else {
        if (upperQueue.size() < lowerQueue.size()) {
          upperQueue.add(num);
        } else {
          lowerQueue.add(num);
        }
      }

      // re-balance
      if (upperQueue.size() - lowerQueue.size() > 1) {
        lowerQueue.add(upperQueue.poll());
      } else if (lowerQueue.size() - upperQueue.size() > 1) {
        upperQueue.add(lowerQueue.poll());
      }
    }

    public double findMedian() {
      if (upperQueue.size() == 1 && lowerQueue.size() == 1) {
        throw new RuntimeException("Can't find median without inserting");
      } if (upperQueue.size() > lowerQueue.size()) {
        return upperQueue.peek();
      } else if (lowerQueue.size() > upperQueue.size()) {
        return lowerQueue.peek();
      } else {
        int lowerMax = lowerQueue.peek();
        int upperMin = upperQueue.peek();
        return (lowerMax + upperMin) / 2.0;
      }
    }
  }

  public static void main(String[] main) {
    MedianFinder mf = new MedianFinder();
    mf.addNum(1);
    mf.addNum(2);
    Assert.assertEquals(1.5, mf.findMedian(), 0.00001);
    mf.addNum(3);
    Assert.assertEquals(2, mf.findMedian(), 0.00001);
  }
}
