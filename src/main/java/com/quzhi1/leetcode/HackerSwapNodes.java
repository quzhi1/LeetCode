package com.quzhi1.leetcode;

import com.quzhi1.leetcode.util.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HackerSwapNodes {

  static int[][] swapNodes(int[][] indexes, int[] queries) {
    // Construct tree
    List<List<TreeNode>> levels = new ArrayList<>();
    TreeNode root = indexesToTreeAndLevel(indexes, levels);

    // Init inorder traversal
    int[][] result = new int[queries.length][inorder(root).split(" ").length];

    // Read queries
    for (int i = 0; i < queries.length; i++) {
      for (int level = 0; level < levels.size(); level++) {
        if ((level + 1) % queries[i] == 0) {
          for (TreeNode node : levels.get(level)) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
          }
        }
      }
      String[] eachResultStrArr = inorder(root).split(" ");
      for (int j = 0; j < eachResultStrArr.length; j++) {
        result[i][j] = Integer.parseInt(eachResultStrArr[j]);
      }
    }
    return result;
  }

  private static TreeNode indexesToTreeAndLevel(int[][] indexes, List<List<TreeNode>> levels) {
    TreeNode root = new TreeNode(1);
    LinkedList<TreeNode> currLevel = new LinkedList<>();
    currLevel.add(root);
    levels.add(new ArrayList<>(currLevel));
    LinkedList<TreeNode> newLevel = new LinkedList<>();
    for (int[] pair : indexes) {
      TreeNode currNode = currLevel.removeFirst();
      if (pair[0] != -1) {
        currNode.left = new TreeNode(pair[0]);
        newLevel.addLast(currNode.left);
      }
      if (pair[1] != -1) {
        currNode.right = new TreeNode(pair[1]);
        newLevel.addLast(currNode.right);
      }
      if (currLevel.isEmpty() && !newLevel.isEmpty()) {
        currLevel = new LinkedList<>(newLevel);
        newLevel.clear();
        levels.add(new ArrayList<>(currLevel));
      }
    }
    return root;
  }

  private static String inorder(TreeNode root) {
    List<String> results = new ArrayList<>(3);
    if (root.left != null) {
      results.add(inorder(root.left));
    }
    results.add(Integer.toString(root.val));
    if (root.right != null) {
      results.add(inorder(root.right));
    }
    return String.join(" ", results);
  }

  public static void main(String[] args) {
    int[][] indexes = new int[][]{
        new int[]{2, 3},
        new int[]{4, -1},
        new int[]{5, -1},
        new int[]{6, -1},
        new int[]{7, 8},
        new int[]{-1, 9},
        new int[]{-1, -1},
        new int[]{10, 11},
        new int[]{-1, -1},
        new int[]{-1, -1},
        new int[]{-1, -1}
    };
//    TreeNode root = indexesToTree(indexes);
//    Map<Integer, String> indexMap = new HashMap<>();
//    indexToInorder(root, indexMap);
    int[][] result = swapNodes(indexes, new int[]{2, 4});
  }
}
