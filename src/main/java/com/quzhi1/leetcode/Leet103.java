package com.quzhi1.leetcode;

import com.quzhi1.leetcode.util.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Leet103 {
  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    boolean reverse = false;
    List<TreeNode> currLevel = new ArrayList<>();
    currLevel.add(root);
    while (!currLevel.isEmpty()) {
      List<Integer> levelResult = currLevel.stream().map(node -> node.val).collect(Collectors.toList());
      if (reverse) {
        Collections.reverse(levelResult);
      }
      result.add(levelResult);
      reverse = !reverse;
      List<TreeNode> currLevelCopy = new ArrayList<>(currLevel);
      currLevel.clear();
      for (TreeNode each: currLevelCopy) {
        if (each.left != null) {
          currLevel.add(each.left);
        }
        if (each.right != null) {
          currLevel.add(each.right);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    List<List<Integer>> result = zigzagLevelOrder(root);
    result.forEach(level -> {
      level.forEach(node -> System.out.print(node + ","));
      System.out.println();
    });
  }
}
