package com.quzhi1.leetcode;

public class HackerElectronicShop {

  static int getMoneySpent(int[] keyboards, int[] drives, int b) {
    int max = -1;
    for (int keyBoard: keyboards) {
      for (int drive: drives) {
        if (b >= keyBoard + drive) {
          max = Math.max(max, keyBoard + drive);
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(getMoneySpent(
        new int[]{3, 1},
        new int[]{5, 2, 8},
        10)); // 9
  }

}
