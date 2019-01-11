package com.quzhi1.leetcode;

import com.quzhi1.leetcode.util.ListNode;

public class Leet234 {

  public static boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }
    int length = length(head);
    int midLength = length % 2 == 0 ? length / 2 : length / 2 + 1;
    ListNode middle = head;
    for (int i = 0; i < midLength; i++) {
      middle = middle.next;
    }
    middle = reverse(middle);
    ListNode headTrack = head;
    ListNode middleTrack = middle;
    for (int i = 0; i < length / 2; i++) {
      if (headTrack.val != middleTrack.val) {
        return false;
      }
      headTrack = headTrack.next;
      middleTrack = middleTrack.next;
    }
    return true;
  }

  private static int length(final ListNode head) {
    int length = 0;
    ListNode progress = head;
    while (progress != null) {
      length++;
      progress = progress.next;
    }
    return length;
  }

  private static ListNode reverse(final ListNode head) {
    if (head != null && head.next != null) {
      ListNode next = head.next;
      ListNode reversedNext = reverse(next);
      next.next = head;
      head.next = null;
      return reversedNext;
    } else {
      return head;
    }
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    System.out.println(isPalindrome(l1));
    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(2);
    l2.next.next = new ListNode(2);
    l2.next.next.next = new ListNode(1);
    System.out.println(isPalindrome(l2));
    ListNode l3 = new ListNode(1);
    l3.next = new ListNode(2);
    l3.next.next = new ListNode(1);
    System.out.println(isPalindrome(l3));
  }
}
