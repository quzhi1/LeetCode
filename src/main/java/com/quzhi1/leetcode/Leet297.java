package com.quzhi1.leetcode;

import com.quzhi1.leetcode.util.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Leet297 {

  // Encodes a tree to a single string.
  public static String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    List<TreeNode> thisLevel = new ArrayList<>();
    thisLevel.add(root);
    while (true) {
      boolean needToGoDown = false;
      List<TreeNode> nextLevel = new ArrayList<>();
      for (TreeNode eachNode : thisLevel) {
        if (eachNode == null) {
          sb.append(",");
          nextLevel.add(null);
          nextLevel.add(null);
        } else {
          sb.append(eachNode.val);
          sb.append(",");
          if (eachNode.left != null) {
            nextLevel.add(eachNode.left);
            needToGoDown = true;
          } else {
            nextLevel.add(null);
          }
          if (eachNode.right != null) {
            nextLevel.add(eachNode.right);
            needToGoDown = true;
          } else {
            nextLevel.add(null);
          }
        }
      }
      if (!needToGoDown) {
        break;
      }
      thisLevel = nextLevel;
    }
    String result = sb.toString();
    return result.substring(0, result.length() - 1);
  }

  // Decodes your encoded data to tree.
  public static TreeNode deserialize(String data) {
    if (data == null || data.isEmpty()) {
      return null;
    }
    String[] nodeArray = data.split(",", -1);
    TreeNode root = new TreeNode(Integer.parseInt(nodeArray[0]));
    List<TreeNode> thisLevel = new ArrayList<>();
    thisLevel.add(root);
    long maxLevel = Math.round(Math.log(nodeArray.length + 1) / Math.log(2));
    if (maxLevel == 1) {
      return root;
    }
    int cursor = 1;
    for (int level = 0; level < maxLevel; level++) {
      List<TreeNode> nextLevel = new ArrayList<>();
      for (TreeNode eachNode : thisLevel) {
        if (eachNode == null) {
          nextLevel.add(null);
          nextLevel.add(null);
          cursor += 2;
        } else {
          if (cursor < nodeArray.length && !"".equals(nodeArray[cursor])) {
            eachNode.left = new TreeNode(Integer.parseInt(nodeArray[cursor]));
          }
          if (cursor + 1 < nodeArray.length && !"".equals(nodeArray[cursor + 1])) {
            eachNode.right = new TreeNode(Integer.parseInt(nodeArray[cursor + 1]));
          }
          nextLevel.add(eachNode.left);
          nextLevel.add(eachNode.right);
          cursor += 2;
        }
      }
      thisLevel = nextLevel;
    }
    return root;
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
