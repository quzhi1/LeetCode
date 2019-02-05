package com.quzhi1.leetcode;

import com.quzhi1.leetcode.util.SinglyLinkedListNode;

public class HackerCycleDetection {
  static boolean hasCycle(SinglyLinkedListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return false;
    }
    SinglyLinkedListNode fast = head.next.next;
    SinglyLinkedListNode slow = head;
    while (fast != slow) {
      if (fast.next == null || fast.next.next == null) {
        return false;
      }
      fast = fast.next.next;
      slow = slow.next;
    }
    return true;
  }
}
