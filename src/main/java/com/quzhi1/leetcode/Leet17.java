package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class Leet17 {

  public static List<String> letterCombinations(String digits) {
    List<String> phoneKeys = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
    List<String> listToPermute = digits.chars()
        .mapToObj(eachChar -> {
          int index = Integer.parseInt(String.valueOf((char) eachChar));
          return phoneKeys.get(index);
        })
        .collect(Collectors.toList());
    return permute(listToPermute);
  }

  private static List<String> permute(List<String> input) {
    if (input.isEmpty()) {
      return input;
    } else if (input.size() == 1) {
      List<String> result = new ArrayList<>();
      for (char eachChar : input.get(0).toCharArray()) {
        result.add(String.valueOf(eachChar));
      }
      return result;
    } else {
      List<String> result = new ArrayList<>();
      for (char head : input.get(0).toCharArray()) {
//        System.out.println("Head: " + head);
        List<String> body = input.subList(1, input.size());
        List<String> permutedBody = permute(body);
        for (String eachBody : permutedBody) {
          result.add(head + eachBody);
        }
      }
      return result;
    }
  }

  public static void main(String[] args) {
    List<String> result1 = letterCombinations("23");
    System.out.println(StringUtils.join(result1, ", "));
  }

}
