package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet773 {

  private static Map<String, Integer> lookUpTable = new HashMap<>();
  private static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  private static int[][] initBoard = new int[][]{{1, 2, 3}, {4, 5, 0}};

  static {
    init();
  }

  public static int slidingPuzzle(int[][] board) {
    String key = serialize(board);
    return lookUpTable.getOrDefault(key, -1);
  }

  private static void init() {
    List<int[][]> currRound = new ArrayList<>();
    currRound.add(initBoard);
    int round = 1;
    lookUpTable.put(serialize(initBoard), 0);
    while (true) {
      int currMapSize = lookUpTable.size();
      List<int[][]> nextRound = nextRound(currRound, round);
      if (currMapSize == lookUpTable.size()) {
        break;
      } else {
        currRound = nextRound;
        round++;
      }
    }
  }

  private static List<int[][]> nextRound(List<int[][]> boards, int round) {
    List<int[][]> result = new ArrayList<>();
    for (int[][] board : boards) {
      for (int[] dir : dirs) {
        int[][] newBoard = swapDirection(board, dir);
        if (newBoard == null) {
          continue;
        }
        String key = serialize(newBoard);
        if (!lookUpTable.containsKey(key)) {
          lookUpTable.put(key, round);
          result.add(newBoard);
        }
      }
    }
    return result;
  }

  private static int[][] swapDirection(int[][] board, int[] dir) {
    int[] zeroLoc = findZero(board);
    int x = zeroLoc[0];
    int y = zeroLoc[1];
    int xx = zeroLoc[0] + dir[0];
    int yy = zeroLoc[1] + dir[1];
    if (xx < 0 || xx > board.length - 1 || yy < 0 || yy > board[0].length - 1) {
      return null;
    } else {
      int[][] newBoard = new int[board.length][board[0].length];
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
          if (i == x && j == y) {
            newBoard[i][j] = board[xx][yy];
          } else if (i == xx && j == yy) {
            newBoard[i][j] = board[x][y];
          } else {
            newBoard[i][j] = board[i][j];
          }
        }
      }
      return newBoard;
    }
  }

  private static int[] findZero(int[][] board) {
    int x = -1, y = -1;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 0) {
          x = i;
          y = j;
        }
      }
    }
    return new int[]{x, y};
  }

  private static String serialize(int[][] board) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < board.length;  i++) {
      for (int j = 0; j < board[0].length; j++) {
        sb.append(board[i][j]);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}})); //1
    System.out.println(slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}})); // -1
    System.out.println(slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}})); // 5
    System.out.println(slidingPuzzle(new int[][]{{3, 2, 4}, {1, 5, 0}})); // 14
  }

}
