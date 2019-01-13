package com.quzhi1.leetcode;

import com.quzhi1.leetcode.util.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leet94 {

  public static List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>(inorderTraversal(root.left));
    result.add(root.val);
    result.addAll(inorderTraversal(root.right));
    return result;
  }

  public static List<Integer> inorderTraversalIterative(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    List<TreeNode> currPath = new ArrayList<>();
    currPath.add(root);
    while (!currPath.isEmpty()) {
      TreeNode currNode = currPath.get(currPath.size() - 1);
//      System.out.println("Looking at " + currNode.val);
      if (currNode.left != null) {
        currPath.add(currNode.left);
//        System.out.println("Add " + currNode.left.val + " to the path");
        currNode.left = null;
      } else {
//        System.out.println("Adding " + currNode.val);
        result.add(currNode.val);
        currPath.remove(currNode);
        if (currNode.right != null) {
          currPath.add(currNode.right);
          currNode.right = null;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    inorderTraversal(root).forEach(val -> System.out.print(val + "->"));
    System.out.println();
    inorderTraversalIterative(root).forEach(val -> System.out.print(val + "->"));
    System.out.println();
  }

}
