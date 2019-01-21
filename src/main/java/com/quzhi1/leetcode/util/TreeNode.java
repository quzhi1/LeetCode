package com.quzhi1.leetcode.util;

public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  @Override
  public boolean equals(Object target) {
    if (target instanceof TreeNode) {
      TreeNode targetNode = ((TreeNode) target);
      if (targetNode.left != null) {
        if (!targetNode.left.equals(this.left)) {
          return false;
        }
      }
      if (targetNode.right != null) {
        if (!targetNode.right.equals(this.right)) {
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }
}
