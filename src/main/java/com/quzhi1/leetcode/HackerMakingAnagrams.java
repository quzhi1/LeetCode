package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;

public class HackerMakingAnagrams {

  static int makeAnagram(String a, String b) {
    Map<Character, Integer> freqMapA = freqMap(a);
    Map<Character, Integer> freqMapB = freqMap(b);
    return distance(freqMapA, freqMapB);
  }

  private static Map<Character, Integer> freqMap(String input) {
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char c : input.toCharArray()) {
      freqMap.merge(c, 1, (i1, i2) -> i1 + 1);
    }
    return freqMap;
  }

  private static int distance(Map<Character, Integer> freqA, Map<Character, Integer> freqB) {
    int result = 0;
    Map<Character, Integer> cloneMapB = new HashMap<>(freqB);
    // A left join B
    for (Map.Entry<Character, Integer> eA : freqA.entrySet()) {
      if (freqB.containsKey(eA.getKey())) {
        result += Math.abs(eA.getValue() - cloneMapB.remove(eA.getKey()));
      } else {
        result += eA.getValue();
      }
    }

    // B's remaining
    for (Map.Entry<Character, Integer> eB : cloneMapB.entrySet()) {
      result += eB.getValue();
    }
    return result;
  }

  public static void main(String[] args) {
    Assert.assertEquals(4, makeAnagram("cde", "abc"));
  }
}
