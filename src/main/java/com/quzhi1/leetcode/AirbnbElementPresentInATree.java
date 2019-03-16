package com.quzhi1.leetcode;

public class AirbnbElementPresentInATree {

  static class Node {

    Node left, right;
    int data;

    Node(int newData) {
      left = right = null;
      data = newData;
    }
  }

  private static int isPresent(Node root, int val) {
    if (root == null) {
      return 0;
    } else if (val == root.data) {
      return 1;
    } else if (val > root.data) {
      return isPresent(root.right, val);
    } else {
      return isPresent(root.left, val);
    }
  }
}
