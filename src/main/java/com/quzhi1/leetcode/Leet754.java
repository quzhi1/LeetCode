package com.quzhi1.leetcode;

import com.quzhi1.leetcode.util.TreeNode;
import java.util.concurrent.LinkedBlockingQueue;

public class Leet754 {

  public static int reachNumber(int target) {
    LinkedBlockingQueue<TreeNode> progressQueue = new LinkedBlockingQueue<>();
    progressQueue.offer(new TreeNode(0));
    for (int level = 1; level < 1000000000; level++) {
      LinkedBlockingQueue<TreeNode> newProgressQueue = new LinkedBlockingQueue<>();
      while (progressQueue.size() != 0) {
        TreeNode oneNode = progressQueue.poll();
        if (constructChild(oneNode, target, level)) {
          return level - 1;
        } else {
          newProgressQueue.offer(oneNode.left);
          newProgressQueue.offer(oneNode.right);
        }
      }
      progressQueue = newProgressQueue;
    }
    return -1;
  }

  public static int reachNumberCorrect(int target) {
    target = Math.abs(target);
    int S = 0;
    int k = 0;
    while (S < target) {
      k++;
      S += k;
    }
    if (S == target) {
      return k;
    } else {
      if ((S - target) % 2 == 0) {
        return k;
      } else {
        k++;
        S += k;
        if ((S - target) % 2 == 0) {
          return k;
        } else {
          return k + 1;
        }
      }
    }
  }

  public static boolean constructChild(final TreeNode parent, final int target, final int level) {
    if (parent.val == target) {
      return true;
    } else {
//            System.out.println("Step " + level + ": pos: " + parent.val);
      parent.left = new TreeNode(parent.val - level);
      parent.right = new TreeNode(parent.val + level);
      return false;
    }
  }

  public static void main(String[] args) {
//        System.out.println(reachNumber(0));
//        System.out.println(reachNumber(1));
    System.out.println(reachNumberCorrect(3));
    System.out.println(reachNumberCorrect(4));
    System.out.println(reachNumberCorrect(7));
    System.out.println(reachNumberCorrect(5));
  }
}
