package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerClimbingLeaderboard {

  static int[] climbingLeaderboard(int[] scores, int[] alice) {
    List<Integer> leaderBoard = new ArrayList<>();
    for (int i = 0; i < scores.length; i++) {
      if (leaderBoard.isEmpty() || leaderBoard.get(leaderBoard.size() - 1) != scores[i]) {
        leaderBoard.add(scores[i]);
//        System.out.print(scores[i] + ", ");
      }
    }
//    System.out.println();
    int[] result = new int[alice.length];
    int anchor = leaderBoard.size();
    for (int i = 0; i < alice.length; i++) {
      boolean anchorSet = false;
      for (int j = anchor - 1; j > -1; j--) {
        if (leaderBoard.get(j) > alice[i]) {
          result[i] = j + 2;
          anchor = Math.min(result[i], leaderBoard.size());
          anchorSet = true;
          break;
        } else if (leaderBoard.get(j) == alice[i]) {
          result[i] = j + 1;
          anchor = result[i];
          anchorSet = true;
          break;
        }
      }
      if (!anchorSet) {
        result[i] = 1;
        anchor = result[i];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] result = climbingLeaderboard(new int[]{100, 100, 50, 40, 40, 20, 10},
        new int[]{5, 25, 50, 120}); // 6,4,2,1
    Arrays.stream(result).forEach(rank -> System.out.print(rank + ", "));
  }

}
