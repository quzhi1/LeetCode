package com.quzhi1.leetcode;

public class HackerQueensAttackII {

  static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
    int[] leftOb = new int[]{r_q, 0};
    int[] rightOb = new int[]{r_q, n + 1};
    int[] upOb = new int[]{0, c_q};
    int[] downOb = new int[]{n + 1, c_q};
    int[] upLeftOb = new int[]{0, 0};
    int[] downLeftOb = new int[]{n + 1, 0};
    int[] upRightOb = new int[]{0, n + 1};
    int[] downRightOb = new int[]{n + 1, n + 1};

    // fill closest obstacle
    for (int[] ob : obstacles) {
      // left
      if (ob[0] == r_q && ob[1] < c_q) {
        leftOb = selectClosest(r_q, c_q, leftOb, ob);
      }
      // right
      else if (ob[0] == r_q && ob[1] > c_q) {
        rightOb = selectClosest(r_q, c_q, rightOb, ob);
      }
      // up
      else if (ob[1] == c_q && ob[0] < r_q) {
        upOb = selectClosest(r_q, c_q, upOb, ob);
      }
      // down
      else if (ob[1] == c_q && ob[0] > r_q) {
        downOb = selectClosest(r_q, c_q, downOb, ob);
      }
      // diagonal
      else if (Math.abs(r_q - ob[0]) == Math.abs(c_q - ob[1])) {
        // up-left
        if (r_q > ob[0] && c_q > ob[1]) {
          upLeftOb = selectClosest(r_q, c_q, upLeftOb, ob);
        }
        // down-left
        else if (r_q < ob[0] && c_q > ob[1]) {
          downLeftOb = selectClosest(r_q, c_q, downLeftOb, ob);
        }
        // up-right
        else if (r_q > ob[0] && c_q < ob[1]) {
          upRightOb = selectClosest(r_q, c_q, upRightOb, ob);
        }
        // down-right
        else if (r_q < ob[0] && c_q < ob[1]) {
          downRightOb = selectClosest(r_q, c_q, downRightOb, ob);
        }
      }
    }

//    System.out.println(obToStr(leftOb));
//    System.out.println(obToStr(rightOb));
//    System.out.println(obToStr(upOb));
//    System.out.println(obToStr(downOb));
//    System.out.println(obToStr(upLeftOb));
//    System.out.println(obToStr(downLeftOb));
//    System.out.println(obToStr(upRightOb));
//    System.out.println(obToStr(downRightOb));

    // Calculate attacks
    int result = 0;
    result += c_q - leftOb[1] - 1;
    result += rightOb[1] - c_q - 1;
    result += r_q - upOb[0] - 1;
    result += downOb[0] - r_q - 1;
    result += Math.min(r_q - upLeftOb[0], c_q - upLeftOb[1]) - 1;
    result += Math.min(downLeftOb[0] - r_q, c_q - downLeftOb[1]) - 1;
    result += Math.min(r_q - upRightOb[0], upRightOb[1] - c_q) - 1;
    result += Math.min(downRightOb[0] - r_q, downRightOb[1] - c_q) - 1;
    return result;
  }

  private static int[] selectClosest(int r_q, int c_q, int[] oldOb, int[] newOb) {
    int oldDist = distance(r_q, c_q, oldOb);
    int newDist = distance(r_q, c_q, newOb);
    if (oldDist > newDist) {
      return newOb;
    } else {
      return oldOb;
    }
  }

  private static int distance(int r_q, int c_q, int[] ob) {
    if (r_q == ob[0]) {
      return Math.abs(ob[1] - c_q);
    } else if (c_q == ob[1]) {
      return Math.abs(ob[0] - r_q);
    } else if (Math.abs(ob[0] - r_q) == Math.abs(ob[1] - c_q)) {
      return Math.abs(ob[0] - r_q);
    } else {
      return Integer.MAX_VALUE;
    }
  }

  private static String obToStr(int[] ob) {
    return ob[0] + ", " + ob[1];
  }

  public static void main(String[] args) {
    System.out.println(queensAttack(4, 0, 4, 4, new int[][]{})); // 9
  }

}
