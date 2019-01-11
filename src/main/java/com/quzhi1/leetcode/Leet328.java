package com.quzhi1.leetcode;

import com.quzhi1.leetcode.util.ListNode;
import java.util.Arrays;

public class Leet328 {

  public static ListNode oddEvenList(final ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    ListNode evenList = null;
    ListNode evenListProgress = null;
    ListNode progress = head;
    ListNode oddListProgress = null;
    boolean odd = true;
    ListNode next;
    do {
      next = progress.next;

      // If it is even, attach to even list
      if (!odd) {
        // .prev should point to .next
        oddListProgress.next = progress.next;

        // Attach even list
        if (evenListProgress == null) {
          evenList = progress;
        } else {
          evenListProgress.next = progress;
        }

        // update even progress
        evenListProgress = progress;
        evenListProgress.next = null;
      }
      // If it is odd, update odd progress
      else {
        oddListProgress = progress;
      }
      progress = next;
      odd = !odd;

      // Debug
//      System.out.println("Odd:");
//      head.printList();
//      System.out.println("Even:");
//      if (evenList != null) {
//        evenList.printList();
//      } else {
//        System.out.println("null");
//      }
    } while (next != null);
    oddListProgress.next = evenList;
    return head;
  }

  public static ListNode oddEvenListBestSolution(ListNode head) {
    if (head != null) {

      ListNode odd = head, even = head.next, evenHead = even;

      while (even != null && even.next != null) {
        odd.next = odd.next.next;
        even.next = even.next.next;
        odd = odd.next;
        even = even.next;
      }
      odd.next = evenHead;
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.listToLinkedList(Arrays.asList(1, 2, 3, 4, 5));
    oddEvenList(head).printList();
    head = ListNode.listToLinkedList(Arrays.asList(2, 1, 3, 5, 6, 4, 7));
    oddEvenList(head).printList();
  }

}
