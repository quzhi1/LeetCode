package com.quzhi1.leetcode;

import com.quzhi1.leetcode.util.TreeNode;

public class Leet105 {

  public static TreeNode buildTree(int[] preorder, int[] inorder) {
//    System.out.println("Root: " + preorder[0]);
    if (preorder.length == 0) {
      return null;
    } else if (preorder.length == 1) {
      return new TreeNode(preorder[0]);
    } else if (preorder.length == 2) {
      TreeNode root = new TreeNode(preorder[0]);
      if (preorder[1] != inorder[1]) {
        root.left = new TreeNode(preorder[1]);
      } else {
        root.right = new TreeNode(preorder[1]);
      }
      return root;
    } else {
      int rootVal = preorder[0];
      int indexOfInorder = -1;
      for (int i = 0; i < inorder.length; i++) {
        if (rootVal == inorder[i]) {
          indexOfInorder = i;
        }
      }

      // Construct preorder arrays
      int[] leftPreorder = new int[indexOfInorder];
      int[] rightPreorder = new int[preorder.length - indexOfInorder - 1];
      for (int i = 0; i < preorder.length; i++) {
        if (i < indexOfInorder) {
          leftPreorder[i] = preorder[i + 1];
        } else if (i > indexOfInorder) {
          rightPreorder[i - indexOfInorder - 1] = preorder[i];
        }
      }

      // Construct inorder arrays
      int[] leftInorder = new int[indexOfInorder];
      int[] rightInorder = new int[inorder.length - indexOfInorder - 1];
      for (int i = 0; i < inorder.length; i++) {
        if (i < indexOfInorder) {
          leftInorder[i] = inorder[i];
        } else if (i > indexOfInorder) {
          rightInorder[i - indexOfInorder - 1] = inorder[i];
        }
      }

      // Construct left & right child
      TreeNode root = new TreeNode(rootVal);
      root.left = buildTree(leftPreorder, leftInorder);
      root.right = buildTree(rightPreorder, rightInorder);
      return root;
    }
  }

  public static void main(String[] args) {
//    int[] preorder = {3, 9, 20, 15, 7};
//    int[] inorder = {9, 3, 15, 20, 7};
//    TreeNode root = buildTree(preorder, inorder);
//    System.out.println(root == null ? "null" : root.val);

    int[] preorder = {1, 2, 3};
    int[] inorder = {3, 2, 1};
    TreeNode root = buildTree(preorder, inorder);
    System.out.println(root == null ? "null" : root.val);
  }
}
