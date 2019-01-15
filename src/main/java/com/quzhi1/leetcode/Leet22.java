package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Leet22 {

  public static List<String> generateParenthesis(int n) {
    if (n == 0) {
      return Collections.emptyList();
    }
    List<String> result = new ArrayList<>();
    addParenthesis(n, 0, 0, "", result);
    return result;
  }

  private static void addParenthesis(int n, int open, int close, String progress, List<String> result) {
    if (open == n && close == n) {
      result.add(progress);
    } else {
      if (open < n) {
        addParenthesis(n, open + 1, close, progress + "(", result);
      }
      if (close < open) {
        addParenthesis(n, open, close + 1, progress + ")", result);
      }
    }
  }

  public static void main(String[] args) {
    List<String> result1 = generateParenthesis(3);
    System.out.println(StringUtils.join(result1, ", "));
  }
}
