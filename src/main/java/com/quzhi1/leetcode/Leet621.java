package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet621 {

  public static int leastInterval(char[] tasks, int n) {
    if (tasks == null || tasks.length == 0) {
      return 0;
    } else if (n == 0) {
      return tasks.length;
    }

    // First collect task frequency
    Map<Character, Integer> taskTimes = new HashMap<>();
    for (char task : tasks) {
      taskTimes.merge(task, 1, (i1, i2) -> i1 + 1);
    }

    // Add them into priority queue
    PriorityQueue<CharTask> pq = new PriorityQueue<>();
    for (Map.Entry<Character, Integer> entry : taskTimes.entrySet()) {
      pq.add(new CharTask(entry.getKey(), entry.getValue()));
    }
    Map<CharTask, Integer> taskWait = new HashMap<>();
    int timeElapse = 0;

    // Execute clock cycle
    do {
      // Execute task from priority queue
      Map<CharTask, Integer> newWait = new HashMap<>();
      if (!pq.isEmpty()) {
        CharTask task = pq.poll();
//        System.out.println("Execute task: " + task.id);
        task.times--;
        if (task.times > 0) {
          newWait.put(task, n - 1);
        }
      } else {
//        System.out.println("Idle");
      }

      // Update waiting list
      for (Map.Entry<CharTask, Integer> entry : taskWait.entrySet()) {
        if (entry.getValue() == 0) {
          if (entry.getKey().times > 0) {
            pq.add(entry.getKey());
          } else {
//            System.out.println("Task " + entry.getKey().id + " is done");
          }
        } else {
          newWait.put(entry.getKey(), entry.getValue() - 1);
        }
      }
      taskWait = newWait;

      // Update clock
      timeElapse++;
    } while (!pq.isEmpty() || !taskWait.isEmpty());
    return timeElapse;
  }

  static class CharTask implements Comparable<CharTask> {

    char id;
    int times;

    private CharTask(char id, int times) {
      this.id = id;
      this.times = times;
    }

    @Override
    public int compareTo(CharTask charTask) {
      return charTask.times - this.times;
    }
  }

  public static void main(String[] args) {
    System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)); // 8
    System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'A', 'B', 'B', 'B'}, 2)); // 10
    System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0)); // 6
  }

}
