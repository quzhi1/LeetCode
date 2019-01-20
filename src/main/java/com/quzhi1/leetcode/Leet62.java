package com.quzhi1.leetcode;

import java.util.Arrays;

public class Leet62 {

  public static int uniquePaths(int m, int n) {
    if (m <= 0 || n <= 0) {
      return 0;
    }
    int[][] grid = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(grid[i], -1);
    }
    return findUniquePath(0, 0, grid);
  }

  private static int findUniquePath(int i, int j, int[][] grid) {
    if (grid[i][j] != -1) {
      return grid[i][j];
    }
    if (i == grid.length - 1) {
      grid[i][j] = 1;
      return 1;
    } else if (j == grid[0].length - 1) {
      grid[i][j] = 1;
      return 1;
    } else {
      grid[i][j] = findUniquePath(i + 1, j, grid) + findUniquePath(i, j + 1, grid);
      return grid[i][j];
    }
  }

  public static void main(String[] main) {
    System.out.println(uniquePaths(3, 2));
    System.out.println(uniquePaths(7, 3));
  }
}
