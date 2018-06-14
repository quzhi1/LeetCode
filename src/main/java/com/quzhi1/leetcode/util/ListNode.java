package com.quzhi1.leetcode.util;

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

    public void printList() {
        ListNode progress = this;
        while (progress != null) {
            System.out.print(progress.val + "->");
            progress = progress.next;
        }
        System.out.println();
    }
}
