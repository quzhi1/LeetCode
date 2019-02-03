package com.quzhi1.leetcode;

public class HackerFormingMagicSquare {

  private static int[][] solution0 = new int[][]{
      new int[]{4, 9, 2},
      new int[]{3, 5, 7},
      new int[]{8, 1, 6},
  };
  private static int[][] solution1 = rotateCounterClock(solution0);
  private static int[][] solution2 = rotateCounterClock(solution1);
  private static int[][] solution3 = rotateCounterClock(solution2);
  private static int[][] solution4 = flipLeftRightSolution(solution0);
  private static int[][] solution5 = rotateCounterClock(solution4);
  private static int[][] solution6 = rotateCounterClock(solution5);
  private static int[][] solution7 = rotateCounterClock(solution6);
  private static int[][][] solutionSet = new int[][][]{solution0, solution1, solution2, solution3, solution4, solution5, solution6,
      solution7};


  static int formingMagicSquare(int[][] s) {
    int min = Integer.MAX_VALUE;
    for (int[][] solution: solutionSet) {
      min = Math.min(min, distance(s, solution));
    }
    return min;
  }

  private static int[][] flipLeftRightSolution(final int[][] s) {
    int[][] result = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        result[i][j] = s[i][2 - j];
      }
    }
    return result;
  }

  private static int[][] rotateCounterClock(final int[][] s) {
    int[][] flipLeftRight = flipLeftRightSolution(s);
    int[][] result = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        result[i][j] = flipLeftRight[j][i];
      }
    }
    return result;
  }

  private static int distance(int[][] s1, int[][] s2) {
    int distance = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3;j++) {
        distance += Math.abs(s1[i][j] - s2[i][j]);
      }
    }
    return distance;
  }

  public static void main(String[] args) {
    System.out.println(formingMagicSquare(new int[][]{
        new int[]{4, 9, 2},
        new int[]{3, 5, 7},
        new int[]{8, 1, 5},
    })); // 1

    System.out.println(formingMagicSquare(new int[][]{
        new int[]{4, 8, 2},
        new int[]{4, 5, 7},
        new int[]{6, 1, 6},
    })); // 4
  }
}
