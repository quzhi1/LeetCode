package com.quzhi1.leetcode;

public class Leet200 {

  public static int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int result = 0;
    LocTreeNode[][] map = new LocTreeNode[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
//          System.out.println("Exploring (" + i + ", " + j + ")");
          map[i][j] = new LocTreeNode();
          // if left is 1
          if (i > 0 && grid[i - 1][j] == '1') {
            map[i][j].boss = map[i - 1][j];
          }
          // up
          if (j > 0 && grid[i][j - 1] == '1') {
            if (map[i][j].boss == null) {
              map[i][j].boss = map[i][j - 1];
            } else {
              LocTreeNode myLeader = map[i][j];
              while (myLeader.boss != null) {
                myLeader = myLeader.boss;
              }
              LocTreeNode hisLeader = map[i][j - 1];
              while (hisLeader.boss != null) {
                hisLeader = hisLeader.boss;
              }
              if (myLeader != hisLeader) {
                myLeader.boss = hisLeader;
                result--;
//                System.out.println("Island already found, myleader: (" + myLeader.x + ", " + myLeader.y + ")"
//                    + ", hisLeader: (" + hisLeader.x + ", " + hisLeader.y + ")"
//                    + ", result: " + result);
              }
            }
          }
          if (map[i][j].boss == null) {
            result++;
//            System.out.println("New island, result: " + result);
          }
        }
      }
    }
    return result;
  }

  static class LocTreeNode {

    LocTreeNode boss;

    LocTreeNode() {
    }
  }

  public static void main(String[] args) {
    char[][] input1 = new char[4][5];
    char[] i1Row0 = {'1', '1', '1', '1', '0'};
    char[] i1Row1 = {'1', '1', '0', '1', '0'};
    char[] i1Row2 = {'1', '1', '0', '0', '0'};
    char[] i1Row3 = {'0', '0', '0', '0', '0'};
    input1[0] = i1Row0;
    input1[1] = i1Row1;
    input1[2] = i1Row2;
    input1[3] = i1Row3;
    System.out.println(numIslands(input1));

    char[][] input2 = new char[4][5];
    char[] i2Row0 = {'1', '1', '0', '0', '0'};
    char[] i2Row1 = {'1', '1', '0', '0', '0'};
    char[] i2Row2 = {'0', '0', '1', '0', '0'};
    char[] i2Row3 = {'0', '0', '0', '1', '1'};
    input2[0] = i2Row0;
    input2[1] = i2Row1;
    input2[2] = i2Row2;
    input2[3] = i2Row3;
    System.out.println(numIslands(input2));

    char[][] input3 = new char[3][3];
    char[] i3Row0 = {'1', '1', '1'};
    char[] i3Row1 = {'0', '1', '0'};
    char[] i3Row2 = {'1', '1', '1'};
    input3[0] = i3Row0;
    input3[1] = i3Row1;
    input3[2] = i3Row2;
    System.out.println(numIslands(input3));

    char[][] input4 = new char[7][7];
    char[] i4Row0 = {'1', '1', '1', '1', '1', '1', '1'};
    char[] i4Row1 = {'0', '0', '0', '0', '0', '0', '1'};
    char[] i4Row2 = {'1', '1', '1', '1', '1', '0', '1'};
    char[] i4Row3 = {'1', '0', '0', '0', '1', '0', '1'};
    char[] i4Row4 = {'1', '0', '1', '0', '1', '0', '1'};
    char[] i4Row5 = {'1', '0', '1', '1', '1', '0', '1'};
    char[] i4Row6 = {'1', '1', '1', '1', '1', '1', '1'};
    input4[0] = i4Row0;
    input4[1] = i4Row1;
    input4[2] = i4Row2;
    input4[3] = i4Row3;
    input4[4] = i4Row4;
    input4[5] = i4Row5;
    input4[6] = i4Row6;
    System.out.println(numIslands(input4));

    char[][] input5 = new char[3][3];
    char[] i5Row0 = {'1', '1', '1'};
    char[] i5Row1 = {'1', '1', '1'};
    char[] i5Row2 = {'1', '1', '1'};
    input5[0] = i5Row0;
    input5[1] = i5Row1;
    input5[2] = i5Row2;
    System.out.println(numIslands(input5));
  }
}
