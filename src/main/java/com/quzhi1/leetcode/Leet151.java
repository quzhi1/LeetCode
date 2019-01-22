package com.quzhi1.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Leet151 {

  public static String reverseWords(String s) {
    List<String> resultList = Arrays.stream(s.split("\\s"))
        .filter(eachWord -> !eachWord.equals(""))
        .collect(Collectors.toList());
    Collections.reverse(resultList);
    return String.join(" ", resultList);
  }

  public static void main(String[] args) {
    System.out.println(reverseWords("the sky is blue"));
  }

}
