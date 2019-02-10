package com.quzhi1.leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class HackerQueueUsing2Stacks {

  private static class Squeue {

    private Stack<Integer> enqueStack = new Stack<>();
    private Stack<Integer> dequeStack = new Stack<>();

    void enqueue(final int val) {
      enqueStack.push(val);
    }

    void dequeue() {
      if (dequeStack.isEmpty()) {
        while (!enqueStack.isEmpty()) {
          dequeStack.push(enqueStack.pop());
        }
      }
      dequeStack.pop();
    }

    void printFront() {
      if (dequeStack.isEmpty()) {
        while (!enqueStack.isEmpty()) {
          dequeStack.push(enqueStack.pop());
        }
      }
      System.out.println(dequeStack.peek());
    }
  }

  public static void main(String[] args) {
    try {
      Squeue squeue = new Squeue();
      BufferedReader reader =
          new BufferedReader(new InputStreamReader(System.in));
      int queryNum = Integer.parseInt(reader.readLine());
      for (int i = 0; i < queryNum; i++) {
        String[] query = reader.readLine().split(" ");
        switch (Integer.parseInt(query[0])) {
          case 1:
            // enqueue
//            System.out.println("enqueue " + query[1]);
            squeue.enqueue(Integer.parseInt(query[1]));
            break;
          case 2:
            // dequeue
//            System.out.println("dequeue");
            squeue.dequeue();
            break;
          case 3:
            // print front
//            System.out.println("print front");
            squeue.printFront();
            break;
        }
      }
    } catch (Exception e) {
      System.out.println("Wrong");
    }
  }

  /* stdin
10
1 42
2
1 14
3
1 28
3
1 60
1 78
2
2
  * */

}
