package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;

public class HackerSherlockAndAnagrams {

  static int sherlockAndAnagrams(String s) {
    int result = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      for (int j = i + 1; j < s.length(); j++) {
        String target = s.substring(i, j);
        for (int offset = 1; offset < s.length() - j + 1; offset++) {
          String input = s.substring(i + offset, j + offset);
          if (isAnagram(target, input)) {
//            System.out.println(target);
            result++;
//            break;
          }
        }
      }
    }
    return result;
  }

  private static boolean isAnagram(String target, String input) {
    Map<Character, Integer> targetMap = strToMap(target);
    Map<Character, Integer> inputMap = strToMap(input);
    for (Map.Entry<Character, Integer> targetEntry : targetMap.entrySet()) {
      if (inputMap.containsKey(targetEntry.getKey())) {
        if (!inputMap.get(targetEntry.getKey()).equals(targetEntry.getValue())) {
          return false;
        }
      } else {
        return false;
      }
    }
    return true;
  }

  private static Map<Character, Integer> strToMap(String input) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c: input.toCharArray()) {
      map.merge(c, 1, (i1, i2) -> i1 + 1);
    }
    return map;
  }

  public static void main(String[] args) {
    Assert.assertEquals(2, sherlockAndAnagrams("mom"));
    Assert.assertEquals(4, sherlockAndAnagrams("abba"));
    Assert.assertEquals(0, sherlockAndAnagrams("abcd"));
    Assert.assertEquals(3, sherlockAndAnagrams("ifailuhkqq"));
    Assert.assertEquals(10, sherlockAndAnagrams("kkkk"));
    Assert.assertEquals(5, sherlockAndAnagrams("cdcd"));
  }
}
