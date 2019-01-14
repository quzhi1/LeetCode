package com.quzhi1.leetcode;

import com.quzhi1.leetcode.util.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leet230 {

  public static int kthSmallest(TreeNode root, int k) {
    return preOrder(root).get(k - 1);
  }

  private static List<Integer> preOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    } else {
      List<Integer> result = new ArrayList<>(preOrder(root.left));
      result.add(root.val);
      result.addAll(preOrder(root.right));
      return result;
    }
  }

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(3);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(4);
    root1.left.right = new TreeNode(2);
    preOrder(root1).forEach(System.out::print);
    System.out.println();
    System.out.println(kthSmallest(root1, 1));

    TreeNode root2 = new TreeNode(5);
    root2.left = new TreeNode(3);
    root2.right = new TreeNode(6);
    root2.left.left = new TreeNode(2);
    root2.left.right = new TreeNode(4);
    root2.left.left.left = new TreeNode(1);
    preOrder(root2).forEach(System.out::print);
    System.out.println();
    System.out.println(kthSmallest(root2, 3));
  }

}
