package com.quzhi1.leetcode;

public class HackerCastleOnTheGrid {

  static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
    // -1 is null, -2 is obstacle
    int[][] map = new int[grid.length][grid[0].length()];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length(); j++) {
        map[i][j] = grid[i].charAt(j) == '.' ? -1 : -2;
      }
    }
    map[startX][startY] = 0;
    int step = 0;
    while (true) {
      step++;
      for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map[0].length; j++) {
          if (map[i][j] == -1) {
            expandMap(map, i, j, step);
            if (i == goalX && j == goalY && map[i][j] != -1) {
//              printMap(map);
              return step;
            }
          }
        }
      }
    }
  }

  private static void expandMap(int[][] map, int x, int y, int step) {
    // left
    for (int j = y - 1; j > -1 && map[x][j] != -2; j--) {
      if (map[x][j] == step - 1) {
        map[x][y] = step;
      }
    }

    // right
    for (int j = y + 1; j < map[0].length && map[x][j] != -2; j++) {
      if (map[x][j] == step - 1) {
        map[x][y] = step;
      }
    }
    // up
    for (int i = x - 1; i > -1 && map[i][y] != -2; i--) {
      if (map[i][y] == step - 1) {
        map[x][y] = step;
      }
    }

    // down
    for (int i = x + 1; i < map.length && map[i][y] != -2; i++) {
      if (map[i][y] == step - 1) {
        map[x][y] = step;
      }
    }
  }

//  private static void printMap(int[][] map) {
//    Arrays.stream(map).forEach(eachRow -> {
//      Arrays.stream(eachRow).forEach(num -> System.out.print(num + ", "));
//      System.out.println();
//    });
//  }

  public static void main(String[] args) {
//    String[] grid = new String[]{".X.",
//        ".X.",
//        "..."};
//    System.out.println(minimumMoves(grid, 0, 0, 0, 2)); // 3
//    System.out.println(minimumMoves(grid, 2, 0, 2, 2)); // 1
    String[] grid = new String[]{
        ".....",
        "..XX.",
        "..X..",
        "..XX.",
        "....."
    };
    System.out.println(minimumMoves(grid, 0, 0, 2, 3)); // 3
  }

}
