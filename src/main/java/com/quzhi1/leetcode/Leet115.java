package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;

public class Leet115 {

  public static int numDistinctSlow(String s, String t) {
    if (t == null || t.length() == 0) {
      return 1;
    }
    Deque<List<Integer>> locList = new LinkedList<>();
    for (char subC : t.toCharArray()) {
      List<Integer> last = new ArrayList<>();
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == subC) {
          last.add(i);
        }
      }
      locList.addLast(last);
    }

    // Decision tree
    return numOfDecisions(-1, locList);
  }

  private static int numOfDecisions(final int start, final Deque<List<Integer>> locQueue) {
    if (locQueue.size() == 0) {
      return 0;
    } else if (locQueue.size() == 1) {
      List<Integer> head = locQueue.removeFirst();
      int result = (int) head.stream().filter(headLoc -> headLoc > start).count();
      locQueue.addFirst(head);
      return result;
    } else {
      List<Integer> head = locQueue.removeFirst();
      int result = head.stream()
          .filter(headLoc -> headLoc > start)
          .map(headLoc -> numOfDecisions(headLoc, locQueue))
          .mapToInt(Integer::intValue).sum();
      locQueue.addFirst(head);
      return result;
    }
  }

  public static int numDistinctSlow2(String s, String t) {
    if (t == null || t.length() == 0) {
      return 1;
    } else if (s == null || s.length() == 0) {
      return 0;
    }
    char head = t.charAt(0);
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == head) {
        result += numDistinctSlow2(s.substring(i + 1), t.substring(1));
      }
    }
    return result;
  }

//  https://leetcode.com/problems/distinct-subsequences/discuss/37327/Easy-to-understand-DP-in-Java
  public static int numDistinct(String S, String T) {
    // array creation
    int[][] mem = new int[T.length()+1][S.length()+1];

    // filling the first row: with 1s
    for(int j=0; j<=S.length(); j++) {
      mem[0][j] = 1;
    }

    // the first column is 0 by default in every other rows but the first, which we need.
    for(int i=0; i<T.length(); i++) {
      for(int j=0; j<S.length(); j++) {
        if(T.charAt(i) == S.charAt(j)) {
          mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
        } else {
          mem[i+1][j+1] = mem[i+1][j];
        }
      }
    }

    return mem[T.length()][S.length()];
  }

  public static void main(final String[] args) {
    Assert.assertEquals(numDistinct("rabbbit", "rabbit"), 3);
    Assert.assertEquals(numDistinct("babgbag", "bag"), 5);
  }

}
