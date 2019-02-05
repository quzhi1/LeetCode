package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HackerSparseArrays {

  static int[] matchingStrings(String[] strings, String[] queries) {
    int[] result = new int[queries.length];
    Map<String, Integer> strFreq = new HashMap<>();
    for (String str : strings) {
      strFreq.merge(str, 1, (i1, i2) -> i1 + 1);
    }
    for (int i = 0; i < queries.length; i++) {
      result[i] = strFreq.containsKey(queries[i]) ? strFreq.get(queries[i]) : 0;
    }
    return result;
  }

}
