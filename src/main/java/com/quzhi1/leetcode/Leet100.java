package com.quzhi1.leetcode;

import com.quzhi1.leetcode.util.TreeNode;

public class Leet100 {

  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    } else if (p == null && q != null || p != null && q == null) {
      return false;
    } else if (p.val != q.val) {
      return false;
    } else {
      boolean leftSame, rightSame;
      if (p.left != null && q.left != null) {
        leftSame = isSameTree(p.left, q.left);
      } else if (p.left == null && q.left == null) {
        leftSame = true;
      } else {
        return false;
      }
      if (p.right != null && q.right != null) {
        rightSame = isSameTree(p.right, q.right);
      } else if (p.right == null && q.right == null) {
        rightSame = true;
      } else {
        return false;
      }
      return leftSame && rightSame;
    }
  }

  public static void main(String[] args) {

  }
}
