package com.quzhi1.leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Voleon1 {

  public static void main(String args[]) throws Exception {
    // Read input
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    List<String> input = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      input.add(reader.readLine());
    }
    int m = Integer.parseInt(reader.readLine());
    List<String> words = new ArrayList<>(m);
    for (int i = 0; i < m; i++) {
      words.add(reader.readLine());
    }

    // Process
    char[][] matrix = preProcess(input);
    List<String> result = words.stream()
        .filter(each -> findWord(matrix, each))
        .sorted(ALPHABETICAL_ORDER)
        .collect(Collectors.toList());
    result.forEach(System.out::println);
  }

  private static Comparator<String> ALPHABETICAL_ORDER = (String str1, String str2) -> {
    int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
    if (res == 0) {
      res = str1.compareTo(str2);
    }
    return res;
  };

  private static boolean findWord(char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board.length];
    resetVisited(visited);

    // first char
    char head = word.charAt(0);
    List<Location> startLoc = findStartLoc(board, head);

    for (Location l : startLoc) {
      visited[l.x][l.y] = true;
      if (findNext(board, word.substring(1), visited, l.x, l.y)) {
        return true;
      }
      resetVisited(visited);
    }
    return false;
  }

  private static void resetVisited(boolean[][] visited) {
    for (int i = 0; i < visited.length; i++) {
      for (int j = 0; j < visited.length; j++) {
        visited[i][j] = false;
      }
    }
  }

  private static boolean findNext(char[][] board, String word, boolean[][] visited, int x, int y) {
    if (word.equals("")) {
      return true;
    }
    char head = word.charAt(0);
    // left
    if (x > 0 && !visited[x - 1][y]) {
      if (board[x - 1][y] == head) {
        visited[x - 1][y] = true;
        boolean result = findNext(board, word.substring(1), visited, x - 1, y);
        visited[x - 1][y] = false;
        if (result) {
          return true;
        }
      }
    }
    // right
    if (x < board.length - 1 && !visited[x + 1][y]) {
      if (board[x + 1][y] == head) {
        visited[x + 1][y] = true;
        boolean result = findNext(board, word.substring(1), visited, x + 1, y);
        visited[x + 1][y] = false;
        if (result) {
          return true;
        }
      }
    }
    // up
    if (y > 0 && !visited[x][y - 1]) {
      if (board[x][y - 1] == head) {
        visited[x][y - 1] = true;
        boolean result = findNext(board, word.substring(1), visited, x, y - 1);
        visited[x][y - 1] = false;
        if (result) {
          return true;
        }
      }
    }
    // down
    if (y < board.length - 1 && !visited[x][y + 1]) {
      if (board[x][y + 1] == head) {
        visited[x][y + 1] = true;
        boolean result = findNext(board, word.substring(1), visited, x, y + 1);
        visited[x][y + 1] = false;
        if (result) {
          return true;
        }
      }
    }
    // upper left
    if (x > 0 && y > 0 && !visited[x - 1][y - 1]) {
      if (board[x - 1][y - 1] == head) {
        visited[x - 1][y - 1] = true;
        boolean result = findNext(board, word.substring(1), visited, x - 1, y - 1);
        visited[x - 1][y - 1] = false;
        if (result) {
          return true;
        }
      }
    }
    // upper right
    if (x < board.length - 1 && y > 0 && !visited[x + 1][y - 1]) {
      if (board[x + 1][y - 1] == head) {
        visited[x + 1][y - 1] = true;
        boolean result = findNext(board, word.substring(1), visited, x + 1, y - 1);
        visited[x + 1][y - 1] = false;
        if (result) {
          return true;
        }
      }
    }
    // lower left
    if (x > 0 && y < board.length - 1 && !visited[x - 1][y + 1]) {
      if (board[x - 1][y + 1] == head) {
        visited[x - 1][y + 1] = true;
        boolean result = findNext(board, word.substring(1), visited, x - 1, y + 1);
        visited[x - 1][y + 1] = false;
        if (result) {
          return true;
        }
      }
    }
    // lower right
    if (x < board.length - 1 && y < board.length - 1 && !visited[x + 1][y + 1]) {
      if (board[x + 1][y + 1] == head) {
        visited[x + 1][y + 1] = true;
        boolean result = findNext(board, word.substring(1), visited, x + 1, y + 1);
        visited[x + 1][y + 1] = false;
        if (result) {
          return true;
        }
      }
    }
    return false;
  }

  private static List<Location> findStartLoc(char[][] board, char head) {
    List<Location> result = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == head) {
          result.add(new Location(i, j));
        }
      }
    }
    return result;
  }

  private static char[][] preProcess(List<String> board) {
    char[][] result = new char[board.size()][board.size()];
    for (int i = 0; i < board.size(); i++) {
      result[i] = board.get(i).toCharArray();
    }
    return result;
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
        return ((Location) target).x == this.x && ((Location) target).y == this.y;
      } else {
        return false;
      }
    }
  }
}
