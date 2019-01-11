package com.quzhi1.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class Leet49 {

  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    Map<Map<Character, Integer>, Integer> solutionMap = new HashMap<>();
    int index = 0;
    for (int i = 0; i < strs.length; i++) {
      Map<Character, Integer> wordMap = wordToHashMap(strs[i]);
      if (solutionMap.get(wordMap) == null) {
        List<String> oneWordList = new ArrayList<>();
        oneWordList.add(strs[i]);
        result.add(oneWordList);
        solutionMap.put(wordMap, index);
        // log
//                System.out.println("Found new word: " + strs[i] + ", put it to index: " + index);
        //
        index++;
      } else {
        int foundIndex = solutionMap.get(wordMap);
        // log
//                System.out.println("Found word: " + strs[i] + " in index: " + foundIndex);
        //
        result.get(foundIndex).add(strs[i]);
      }
    }
    return result;
  }

  private static Map<Character, Integer> wordToHashMap(final String str) {
    Map<Character, Integer> wordMap = new HashMap<>();
    for (int j = 0; j < str.length(); j++) {
      if (wordMap.get(str.charAt(j)) == null) {
        wordMap.put(str.charAt(j), 1);
      } else {
        wordMap.put(str.charAt(j), wordMap.get(str.charAt(j)) + 1);
      }
    }
    return wordMap;
  }

  public static void main(String[] args) {
    String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
    printResult(groupAnagrams(input));
  }

  public static void printResult(final List<List<String>> result) {
    System.out.println("Solution");
    result.forEach(eachResult ->
        System.out.println(StringUtils.join(eachResult, ","))
    );
  }
}
