package com.quzhi1.leetcode;

public class Leet116 {

  public static void connect(TreeLinkNode root) {
    if (root != null && root.left != null && root.left.left == null) {
      // That means this tree is two level
      root.left.next = root.right;
//      System.out.println(root.left.val + " -> " + root.right.val);
    } else if (root != null && root.left != null && root.left.left != null) {
      // That means this tree is at least three level
      root.left.next = root.right;
//      System.out.println(root.left.right.val + " -> " + root.right.left.val);
      connect(root.left);
      connect(root.right);
      TreeLinkNode fakeNode = new TreeLinkNode(-1);
      fakeNode.left = root.left.right;
      fakeNode.right = root.right.left;
      connect(fakeNode);
    }
  }

  static class TreeLinkNode {

    public int val;
    public TreeLinkNode left, right, next;

    public TreeLinkNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    TreeLinkNode root = new TreeLinkNode(1);
    root.left = new TreeLinkNode(2);
    root.right = new TreeLinkNode(3);
    root.left.left = new TreeLinkNode(4);
    root.left.right = new TreeLinkNode(5);
    root.right.left = new TreeLinkNode(6);
    root.right.right = new TreeLinkNode(7);
    root.left.left.left = new TreeLinkNode(8);
    root.left.left.right = new TreeLinkNode(9);
    root.left.right.left = new TreeLinkNode(10);
    root.left.right.right = new TreeLinkNode(11);
    root.right.left.left = new TreeLinkNode(12);
    root.right.left.right = new TreeLinkNode(13);
    root.right.right.left = new TreeLinkNode(14);
    root.right.right.right = new TreeLinkNode(15);

    connect(root);
  }

}
