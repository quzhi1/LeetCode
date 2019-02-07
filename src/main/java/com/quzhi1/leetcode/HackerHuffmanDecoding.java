package com.quzhi1.leetcode;

import com.quzhi1.leetcode.util.Node;

public class HackerHuffmanDecoding {

  static void decode(String s, Node root) {
    if (s == null || s.isEmpty() || root == null || root.left == null || root.right == null) {
      return;
    }
    StringBuilder resultBuilder = new StringBuilder();
    Node progressNode = root;
    for (char c : s.toCharArray()) {
      progressNode = c == '0' ? progressNode.left : progressNode.right;
      if (progressNode.left == null && progressNode.right == null) {
        resultBuilder.append(progressNode.data);
        progressNode = root;
      }
    }
    System.out.println(resultBuilder.toString());
  }

  public static void main(String[] args) {
    Node root = new Node(' ');
    root.left = new Node('A');
    root.right = new Node(' ');
    root.right.left = new Node('R');
    root.right.right = new Node(' ');
    root.right.right.left = new Node(' ');
    root.right.right.right = new Node('B');
    root.right.right.left = new Node(' ');
    root.right.right.left.left = new Node('C');
    root.right.right.left.right = new Node('D');
    String huff = "01111001100011010111100";
    decode(huff, root); // ABRACADABRA
  }
}
