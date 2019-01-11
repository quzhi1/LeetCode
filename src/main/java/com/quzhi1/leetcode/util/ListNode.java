package com.quzhi1.leetcode.util;

import java.util.List;

public class ListNode {

  public int val;
  public ListNode next;

  public ListNode(final int x) {
    val = x;
  }

  public ListNode(final int[] nums) {
    if (nums.length == 0) {
      throw new RuntimeException("Empty list");
    } else {
      ListNode result = new ListNode(nums[0]);
      ListNode progress = result;
      for (int i = 1; i < nums.length; i++) {
        progress.next = new ListNode(nums[i]);
        progress = progress.next;
      }
      this.val = result.val;
      this.next = result.next;
    }
  }

  public static ListNode listToLinkedList(final List<Integer> input) {
    if (input == null || input.isEmpty()) {
      return null;
    } else {
      ListNode head = new ListNode(input.get(0));
      ListNode progress = head;
      for (int i = 1; i < input.size(); i++) {
        progress.next = new ListNode(input.get(i));
        progress = progress.next;
      }
      return head;
    }
  }

  public void printList() {
    ListNode progress = this;
    while (progress != null) {
      System.out.print(progress.val + "->");
      progress = progress.next;
    }
    System.out.println();
  }
}
