package com.quzhi1.leetcode;

public class HackerSelfBalancingTree {

  private static class Node {

    int val;  //Value
    int ht;    //Height
    Node left;  //Left child
    Node right;  //Right child
  }

  static Node insert(Node root, int val) {
    // insert
    if (root == null) {
      Node newRoot = new Node();
      newRoot.val = val;
      newRoot.ht = 0;
      return newRoot;
    }
    if (val < root.val) {
      root.left = insert(root.left, val);
    } else {
      root.right = insert(root.right, val);
    }
    root.ht = Math.max(height(root.left), height(root.right)) + 1;

    // rotate
    root = rotate(root);
    return root;
  }

  private static Node rotate(Node root) {
    if (root == null) {
      return null;
    } else if (height(root.left) - height(root.right) > 1) {
      rotate(root.left);
      rotate(root.right);
      if (height(root.left.left) > height(root.left.right)) {
        // left left
        return rotate(leftLeftRotate(root));
      } else {
        // left right
        return rotate(leftRightRotate(root));
      }
    } else if (height(root.right) - height(root.left) > 1) {
      if (height(root.right.right) > height(root.right.left)) {
        // right right
        return rotate(rightRightRotate(root));
      } else {
        // right left
        return rotate(rightLeftRotate(root));
      }
    } else {
      return root;
    }
  }

  private static int height(Node root) {
    return root == null ? -1 : root.ht;
  }

  private static Node leftRightRotate(Node yellow) {
    Node green = yellow.left;
    Node red = yellow.left.right;

    Node b = red.left;
    Node c = red.right;

    green.right = b;
    yellow.left = c;
    red.left = green;
    red.right = yellow;

    yellow.ht -= 2;
    green.ht--;
    red.ht++;
    return red;
  }

  private static Node leftLeftRotate(Node yellow) {
    Node red = yellow.left;
    yellow.left = red.right;
    red.right = yellow;

    yellow.ht -= 2;
    return red;
  }

  private static Node rightLeftRotate(Node green) {
    Node yellow = green.right;
    Node red = green.right.left;

    Node b = red.left;
    Node c = red.right;

    green.right = b;
    yellow.left = c;
    red.left = green;
    red.right = yellow;

    green.ht -= 2;
    yellow.ht--;
    red.ht++;
    return red;
  }

  private static Node rightRightRotate(Node green) {
    Node red = green.right;
    green.right = red.left;
    red.left = green;

    green.ht -= 2;
    return red;
  }

  public static void main(String[] args) {
//    // left right
//    Node root = new Node();
//    root.val = 5;
//    root = insert(root, 3);
//    root = insert(root, 4);
//    System.out.println(root.val); // 4
//    System.out.println(root.left.val); // 3
//    System.out.println(root.right.val); // 5

//    // left left
//    Node root = new Node();
//    root.val = 5;
//    root = insert(root, 4);
//    root = insert(root, 3);
//    System.out.println(root.val); // 4
//    System.out.println(root.left.val); // 3
//    System.out.println(root.right.val); // 5

//    // right left
//    Node root = new Node();
//    root.val = 3;
//    root = insert(root, 5);
//    root = insert(root, 4);
//    System.out.println(root.val); // 4
//    System.out.println(root.left.val); // 3
//    System.out.println(root.right.val); // 5

//    // right right
//    Node root = new Node();
//    root.val = 3;
//    root = insert(root, 4);
//    root = insert(root, 5);
//    System.out.println(root.val); // 4
//    System.out.println(root.left.val); // 3
//    System.out.println(root.right.val); // 5

//    // 2 levels, 1 rotate
//    Node root = new Node();
//    root.val = 6;
//    root = insert(root, 5);
//    root = insert(root, 3);
//    root = insert(root, 4);
//    System.out.println(root.val); // 5
//    System.out.println(root.left.val); // 3
//    System.out.println(root.right.val); // 6
//    System.out.println(root.left.right.val); // 4

//    // 2 levels, 1 rotates
//    Node root = new Node();
//    root.val = 3;
//    root = insert(root, 2);
//    root = insert(root, 4);
//    root = insert(root, 5);
//    root = insert(root, 6);
//    System.out.println(root.val); // 3
//    System.out.println(root.left.val); // 2
//    System.out.println(root.right.val); // 5
//    System.out.println(root.right.left.val); // 4
//    System.out.println(root.right.right.val); // 6

//    // 2 levels, 1 rotates
//    Node root = new Node();
//    root.val = 3;
//    root = insert(root, 2);
//    root = insert(root, 4);
//    root = insert(root, 5);
//    root = insert(root, 6);
//    System.out.println(root.val); // 3
//    System.out.println(root.left.val); // 2
//    System.out.println(root.right.val); // 5
//    System.out.println(root.right.left.val); // 4
//    System.out.println(root.right.right.val); // 6

    // 3 levels, 1 rotates
    Node root = new Node();
    root.val = 6;
    root = insert(root, 3);
    root = insert(root, 7);
    root = insert(root, 2);
    root = insert(root, 4);
    root = insert(root, 5);
    System.out.println(root.val); // 4
    System.out.println(root.left.val); // 3
    System.out.println(root.right.val); // 6
    System.out.println(root.left.left.val); // 2
    System.out.println(root.right.left.val); // 5
    System.out.println(root.right.right.val); // 7
  }
}
