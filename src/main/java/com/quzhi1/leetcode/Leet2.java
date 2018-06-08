package com.quzhi1.leetcode;

public class Leet2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode digit1 = l1;
        ListNode digit2 = l2;
        ListNode resultHead = new ListNode((l1.val + l2.val) % 10);
        int carry = (l1.val + l2.val) / 10;
        ListNode digitResult = resultHead;
        while (digit1.next != null || digit2.next != null || carry != 0) {
            if (digit1.next != null && digit2.next != null) {
                digitResult.next = new ListNode((digit1.next.val + digit2.next.val + carry) % 10);
                carry = (digit1.next.val + digit2.next.val + carry) / 10;
                digit1 = digit1.next;
                digit2 = digit2.next;
            } else if (digit1.next == null && digit2.next != null) {
                digitResult.next = new ListNode((digit2.next.val + carry) % 10);
                carry = (digit2.next.val + carry) / 10;
                digit2 = digit2.next;
            } else if (digit1.next != null && digit2.next == null) {
                digitResult.next = new ListNode((digit1.next.val + carry) % 10);
                carry = (digit1.next.val + carry) / 10;
                digit1 = digit1.next;
            } else if (digit1.next == null && digit2.next == null && carry == 1) {
                digitResult.next = new ListNode(1);
                carry = 0;
            }
            digitResult = digitResult.next;
        }
        return resultHead;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
//        a.next = new ListNode(4);
//        a.next.next = new ListNode(5);
//        a.next.next.next = new ListNode(3);

        ListNode b = new ListNode(9);
        b.next = new ListNode(9);
//        b.next.next = new ListNode(4);

        printList(addTwoNumbers(a, b));
    }

    private static void printList(final ListNode head) {
        ListNode progress = head;
        while (progress != null) {
            System.out.print(progress.val + "->");
            progress = progress.next;
        }
        System.out.println();
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
