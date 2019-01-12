package com.quzhi1.leetcode;

import com.quzhi1.leetcode.util.ListNode;

public class Leet160 {

  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode progressA = headA;
    ListNode progressB = headB;
    boolean aEnd = false;
    boolean aReallyEnd = false;
    boolean bEnd = false;
    boolean bReallyEnd = false;
    while (!aReallyEnd && !bReallyEnd) {
      // If a to the end, redirect to b. If end again, stop
      if (progressA.next != null) {
        progressA = progressA.next;
      } else if (!aEnd) {
        progressA = headB;
        aEnd = true;
      } else {
        aReallyEnd = true;
      }

      // If b to the end, redirect to a. If end again, stop
      if (progressB.next != null) {
        progressB = progressB.next;
      } else if (!bEnd) {
        progressB = headA;
        bEnd = true;
      } else {
        bReallyEnd = true;
      }

      // If a and b both experienced redirect, check equality
      if (aEnd && bEnd && progressA == progressB) {
        return progressA;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    ListNode headA = new ListNode(3);
    headA.next = new ListNode(4);
    headA.next.next = new ListNode(5);
    headA.next.next.next = new ListNode(10);

    ListNode headB = new ListNode(6);
    headB.next = headA.next.next;

    System.out.println(getIntersectionNode(headA, headB).val);
  }

}
