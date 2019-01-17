package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet347 {

  public static List<Integer> topKFrequent(int[] nums, int k) {
    PriorityQueue<NumFreq> heap = new PriorityQueue<>();
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int num : nums) {
      if (freqMap.get(num) == null) {
        freqMap.put(num, 0);
      } else {
        freqMap.put(num, freqMap.get(num) + 1);
      }
    }
    for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
      heap.add(new NumFreq(entry.getKey(), entry.getValue()));
    }
    List<Integer> result = new ArrayList<>(k);
    for (int i = 0; i < k; i++) {
      result.add(heap.poll().value);
    }
    return result;
  }

  static class NumFreq implements Comparable<NumFreq> {

    int value, freq;

    NumFreq(int value, int freq) {
      this.value = value;
      this.freq = freq;
    }

    @Override
    public int compareTo(NumFreq numFreq) {
      return numFreq.freq - this.freq;
    }
  }

  public static void main(final String[] args) {
    int[] nums = {1, 1, 1, 2, 2, 3};
    topKFrequent(nums, 2).forEach(num -> System.out.print(num + ","));

  }

}
