package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;

public class HackerSherlockAndTheValidString {

  static String isValid(String s) {
    Map<Character, Integer> charFreq = new HashMap<>();
    for (char c : s.toCharArray()) {
      charFreq.merge(c, 1, (i1, i2) -> i1 + 1);
    }
    HashMap<Integer, Integer> freqRecord = new HashMap<>();
    for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
      freqRecord.merge(entry.getValue(), 1, (i1, i2) -> i1 + 1);
      if (freqRecord.size() > 2) {
        return "NO";
      }
    }
    if (freqRecord.size() == 1) {
      return "YES";
    } else {
      List<Integer> freqs = new ArrayList<>(freqRecord.keySet());
      int lowKey = Math.min(freqs.get(0), freqs.get(1));
      int highKey = Math.max(freqs.get(0), freqs.get(1));
      if (highKey == lowKey + 1 && freqRecord.get(highKey) == 1) {
        return "YES";
      } else if (lowKey == 1 && freqRecord.get(lowKey) == 1) {
        return "YES";
      } else {
        return "NO";
      }
    }
  }

  public static void main(String[] args) {
    Assert.assertEquals("NO", isValid("aabbcd"));
    Assert.assertEquals("NO", isValid("aabbccddeefghi"));
    Assert.assertEquals("YES", isValid("abcdefghhgfedecba"));
    Assert.assertEquals("YES", isValid("aabbc"));
  }
}
