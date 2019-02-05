package com.quzhi1.leetcode.util;

import java.util.List;

public class SinglyLinkedListNode {

  public int data;
  public SinglyLinkedListNode next;

  public SinglyLinkedListNode(final int x) {
    data = x;
  }

  public SinglyLinkedListNode(final int[] nums) {
    if (nums.length == 0) {
      throw new RuntimeException("Empty list");
    } else {
      SinglyLinkedListNode result = new SinglyLinkedListNode(nums[0]);
      SinglyLinkedListNode progress = result;
      for (int i = 1; i < nums.length; i++) {
        progress.next = new SinglyLinkedListNode(nums[i]);
        progress = progress.next;
      }
      this.data = result.data;
      this.next = result.next;
    }
  }

  public static SinglyLinkedListNode listToLinkedList(final List<Integer> input) {
    if (input == null || input.isEmpty()) {
      return null;
    } else {
      SinglyLinkedListNode head = new SinglyLinkedListNode(input.get(0));
      SinglyLinkedListNode progress = head;
      for (int i = 1; i < input.size(); i++) {
        progress.next = new SinglyLinkedListNode(input.get(i));
        progress = progress.next;
      }
      return head;
    }
  }

  public void printList() {
    SinglyLinkedListNode progress = this;
    while (progress != null) {
      System.out.print(progress.data + "->");
      progress = progress.next;
    }
    System.out.println();
  }
}
