package com.quzhi1.leetcode;

public class HackerPageCount {

  static int pageCount(int n, int p) {
    int countFromFront = p / 2;
    int totalCount = n / 2;
    return Math.min(countFromFront, totalCount - countFromFront);
  }

  public static void main(String[] args) {
  }
}
