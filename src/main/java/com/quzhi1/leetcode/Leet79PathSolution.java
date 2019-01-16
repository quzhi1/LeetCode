package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet79PathSolution {

  public static boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || board[0].length == 0 || board.length * board[0].length < word.length()) {
      return false;
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        List<Location> path = new ArrayList<>();
        path.add(new Location(i, j));
        if (proceed(board, word, path)) {
          return true;
        }
        path.clear();
      }
    }
    return false;
  }

  private static boolean proceed(char[][] board, String word, List<Location> path) {
    if (path.size() < 1) {
      throw new RuntimeException("Shouldn't be in this loop");
    }
    if (word.length() == 0) {
      return true;
    } else if (word.length() == 1) {
      Location tail = path.get(path.size() - 1);
      if (board[tail.x][tail.y] == word.charAt(0)) {
//        System.out.println(
//            String.format("checking location (%s, %s): %s for word: %s", tail.x, tail.y, board[tail.x][tail.y], word));
        return true;
      } else {
        return false;
      }
    } else {
      Location tail = path.get(path.size() - 1);
      if (board[tail.x][tail.y] == word.charAt(0)) {
//        System.out.println(
//            String.format("checking location (%s, %s): %s for word: %s", tail.x, tail.y, board[tail.x][tail.y], word));

        // left
        if (tail.x > 0 && !path.contains(new Location(tail.x - 1, tail.y))) {
          List<Location> newPath = new ArrayList<>(path);
          newPath.add(new Location(tail.x - 1, tail.y));
          if (proceed(board, word.substring(1), newPath)) {
            return true;
          }
        }

        // right
        if (tail.x < board.length - 1 && !path.contains(new Location(tail.x + 1, tail.y))) {
          List<Location> newPath = new ArrayList<>(path);
          newPath.add(new Location(tail.x + 1, tail.y));
          if (proceed(board, word.substring(1), newPath)) {
            return true;
          }
        }

        // up
        if (tail.y > 0 && !path.contains(new Location(tail.x, tail.y - 1))) {
          List<Location> newPath = new ArrayList<>(path);
          newPath.add(new Location(tail.x, tail.y - 1));
          if (proceed(board, word.substring(1), newPath)) {
            return true;
          }
        }

        // right
        if (tail.y < board[0].length - 1 && !path.contains(new Location(tail.x, tail.y + 1))) {
          List<Location> newPath = new ArrayList<>(path);
          newPath.add(new Location(tail.x, tail.y + 1));
          if (proceed(board, word.substring(1), newPath)) {
            return true;
          }
        }
        return false;
      } else {
        return false;
      }
    }
  }

  static class Location {

    int x, y;

    Location(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object target) {
      if (target instanceof Location) {
        return ((Location)target).x == this.x && ((Location)target).y == this.y;
      } else {
        return false;
      }
    }
  }

  public static void main(String[] args) {
    char[][] board = new char[3][4];
    char[] row0 = {'A', 'B', 'C', 'E'};
    char[] row1 = {'S', 'F', 'C', 'S'};
    char[] row2 = {'A', 'D', 'E', 'E'};
    board[0] = row0;
    board[1] = row1;
    board[2] = row2;
//    System.out.println(exist(board, "ABCCED"));
//    System.out.println(exist(board, "SEE"));
//    System.out.println(exist(board, "ABCB"));
  }
}
