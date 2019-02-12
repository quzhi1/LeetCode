package com.quzhi1.leetcode;

public class HackerCastleOnTheGridTLE {

  static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
    // Read grid
    boolean[][] map = new boolean[grid.length][grid[0].length()];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length(); j++) {
        map[i][j] = grid[i].charAt(j) == '.';
      }
    }
    map[startX][startY] = false;

    // Move
    return move(map, startX, startY, goalX, goalY, 0, Integer.MAX_VALUE);
  }

  private static int move(boolean[][] map, int startX, int startY, int goalX, int goalY,
      int steps, Integer min) {
//    System.out.println("Visiting " + startX + ", " + startY);
    int newMin = min;
    if (startX == goalX && startY == goalY) {
//      System.out.println("Found steps: " + steps);
      return Math.min(min, steps);
    }
//    boolean[][] backup = cloneMap(map);

    // left
    int leftMost = startY;
    for (int j = startY - 1; j > -1 && map[startX][j]; j--) {
      leftMost = j;
      map[startX][j] = false;
      // Set front barrier
      boolean setFront = false;
      if (j != 0 && map[startX][j - 1]) {
        map[startX][j - 1] = false;
        setFront = true;
      }
      newMin = Math.min(newMin, move(map, startX, j, goalX, goalY, steps + 1, min));
      // Unset front barrier
      if (setFront) {
        map[startX][j - 1] = true;
      }
    }
    for (int j = startY - 1; j >= leftMost; j--) {
      // unset path
      map[startX][j] = true;
//      if (!backup[startX][j]) {
//        throw new RuntimeException("Resetting wrong location");
//      }
    }
//    mapEqual(backup, map);

    // right
    int rightMost = startY;
    for (int j = startY + 1; j < map.length && map[startX][j]; j++) {
      rightMost = j;
      map[startX][j] = false;
      // Set front barrier
      boolean setFront = false;
      if (j != map.length - 1 && map[startX][j + 1]) {
        map[startX][j + 1] = false;
        setFront = true;
      }
      newMin = Math.min(newMin, move(map, startX, j, goalX, goalY, steps + 1, min));
      // Unset front barrier
      if (setFront) {
        map[startX][j + 1] = true;
      }
    }
    for (int j = startY + 1; j <= rightMost; j++) {
      // unset path
      map[startX][j] = true;
//      if (!backup[startX][j]) {
//        throw new RuntimeException("Resetting wrong location");
//      }
    }
//    mapEqual(backup, map);

    // up
    int upMost = startX;
    for (int i = startX - 1; i > -1 && map[i][startY]; i--) {
      upMost = i;
      map[i][startY] = false;
      // Set front barrier
      boolean setFront = false;
      if (i != 0 && map[i - 1][startY]) {
        map[i - 1][startY] = false;
        setFront = true;
      }
      newMin = Math.min(newMin, move(map, i, startY, goalX, goalY, steps + 1, min));
      // Unset front barrier
      if (setFront) {
        map[i - 1][startY] = true;
      }
    }
    for (int i = startX - 1; i >= upMost; i--) {
      // unset path
      map[i][startY] = true;
//      if (!backup[i][startY]) {
//        throw new RuntimeException("Resetting wrong location");
//      }
    }
//    mapEqual(backup, map);

    // down
    int downMost = startX;
    for (int i = startX + 1; i < map.length && map[i][startY]; i++) {
      downMost = i;
      map[i][startY] = false;
      // Set front barrier
      boolean setFront = false;
      if (i != map.length - 1 && map[i + 1][startY]) {
        map[i + 1][startY] = false;
        setFront = true;
      }
      newMin = Math.min(newMin, move(map, i, startY, goalX, goalY, steps + 1, min));
      // Unset front barrier
      if (setFront) {
        map[i + 1][startY] = true;
      }
    }
    for (int i = startX + 1; i <= downMost; i++) {
      // unset path
      map[i][startY] = true;
//      if (!backup[i][startY]) {
//        throw new RuntimeException("Resetting wrong location");
//      }
    }
//    mapEqual(backup, map);
    return newMin;
  }

//  private static boolean[][] cloneMap(boolean[][] map) {
//    return Arrays.stream(map)
//        .map(boolean[]::clone)
//        .toArray(boolean[][]::new);
//  }

//  private static void mapEqual(boolean[][] map1, boolean[][] map2) {
//    for (int i = 0; i < map1.length; i++) {
//      for (int j = 0; j < map1[0].length; j++) {
//        if (map1[i][j] != map2[i][j]) {
//          throw new RuntimeException("[" + i + ", " + j + "] not equal");
//        }
//      }
//    }
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
