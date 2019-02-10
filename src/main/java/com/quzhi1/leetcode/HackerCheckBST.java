package com.quzhi1.leetcode;

public class HackerCheckBST {

  private static class Node {

    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
    }
  }

  static boolean checkBST(Node root) {
    try {
      maxBst(root);
      return true;
    } catch (RuntimeException e) {
      return false;
    }
  }

  private static NodeStats maxBst(Node root) {
    if (root == null) {
      return null;
    }
    boolean leftTrue = root.left == null || maxBst(root.left).max < root.data;
    boolean rightTrue = root.right == null || maxBst(root.right).min > root.data;
    if (leftTrue && rightTrue) {
      return new NodeStats(root.right == null ? root.data : maxBst(root.right).max,
          root.left == null ? root.data : maxBst(root.left).min);
    } else {
      throw new RuntimeException("Not good");
    }
  }

  private static class NodeStats {

    int max, min;

    NodeStats(int max, int min) {
      this.max = max;
      this.min = min;
    }
  }

  public static void main(String[] args) {
    Node root = new Node(3);
    root.left = new Node(5);
    root.right = new Node(2);
    root.left.left = new Node(1);
    root.left.right = new Node(4);
    root.right.left = new Node(6);
    System.out.println(checkBST(root)); // false
  }
}
