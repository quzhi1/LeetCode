package com.quzhi1.leetcode;

public class Leet79InPlaceSolution {

  public static boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || board[0].length == 0 || board.length * board[0].length < word.length()
        || word.length() == 0) {
      return false;
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (proceed(board, word, "", i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean proceed(char[][] board, String word, String progress, int x, int y) {
    if (board[x][y] == word.charAt(progress.length())) {
      char nextChar = board[x][y];
      progress = progress + nextChar;
      if (progress.length() == word.length()) {
        return true;
      } else if (progress.length() > word.length()) {
        throw new RuntimeException("Shouldn't be in this");
      } else {
        board[x][y] = '*';
        if (x > 0 && proceed(board, word, progress, x - 1, y)) {
          /* "关于回溯要注意的是，如果返回True其实就结束了，以为已经找到答案了，也不需要回溯。如果不返回True，而是改变一个全局变量self.res的值为True，会超时"
           * https://www.jianshu.com/p/1625480b71f3 */
          return true;
        }
        if (x < board.length - 1 && proceed(board, word, progress, x + 1, y)) {
          return true;
        }
        if (y > 0 && proceed(board, word, progress, x, y - 1)) {
          return true;
        }
        if (y < board[0].length - 1 && proceed(board, word, progress, x, y + 1)) {
          return true;
        }
        board[x][y] = nextChar;
        return false;
      }
    } else {
      return false;
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
    System.out.println(exist(board, "SEE"));
//    System.out.println(exist(board, "ABCB"));

//    char[][] board = new char[5][1];
//    char[] row0 = {'b'};
//    char[] row1 = {'a'};
//    char[] row2 = {'b'};
//    char[] row3 = {'b'};
//    char[] row4 = {'a'};
//    board[0] = row0;
//    board[1] = row1;
//    board[2] = row2;
//    board[3] = row3;
//    board[4] = row4;
//    System.out.println(exist(board, "baa"));
  }
}
