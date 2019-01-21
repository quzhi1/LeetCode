package com.quzhi1.leetcode;

import com.quzhi1.leetcode.util.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leet297Dfs {

  // Encodes a tree to a single string.
  public static String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }
    return root.val + "," + serialize(root.left) + "," + serialize(root.right);
  }


  // Decodes your encoded data to tree.
  public static TreeNode deserialize(String data) {
    if (data == null || data.isEmpty()) {
      return null;
    }
    List<String> preOrderStr = new LinkedList<>(Arrays.asList(data.split(",", -1)));
    return deserializeRecursive(preOrderStr);
  }

  private static TreeNode deserializeRecursive(List<String> preOrderStr) {
    if (preOrderStr.get(0).equals("")) {
      preOrderStr.remove(0);
      return null;
    } else {
      TreeNode root = new TreeNode(Integer.parseInt(preOrderStr.get(0)));
      preOrderStr.remove(0);
      root.left = deserializeRecursive(preOrderStr);
      root.right = deserializeRecursive(preOrderStr);
      return root;
    }
  }

  public static void main(String[] main) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    root.right.right.right = new TreeNode(6);

    String encodedTree = serialize(root);
    System.out.println(encodedTree);
    TreeNode decoded = deserialize(encodedTree);
    System.out.println(decoded.equals(root));
  }

}
