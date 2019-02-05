package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HackerArrayManipulation {

  static long arrayManipulation(int n, int[][] queries) {
    LinkedList<Domain> domains = new LinkedList<>();
    for (int[] query : queries) {
      domains.add(new Domain(query[0], query[1], query[2]));
    }
    domains.sort(Domain::compareTo);
//    domains.stream().map(Domain::toString).forEach(System.out::println);
    Map<Integer, Integer> pendingDomain = new HashMap<>();
    long max = 0;
    long currentHeight = 0;
    for (int i = 1; i < n + 1; i++) {
      // Add new domain
      while (!domains.isEmpty() && domains.getFirst().start <= i) {
        Domain domain = domains.removeFirst();
        pendingDomain.merge(domain.end, domain.height, (i1, i2) -> i1 + i2);
        currentHeight += domain.height;
      }
      // Remove old domain
      if (pendingDomain.containsKey(i - 1)) {
        currentHeight -= pendingDomain.remove(i - 1);
      }
      max = Math.max(max, currentHeight);
    }
    return max;
  }

  private static class Domain implements Comparable<Domain> {

    int start, end, height;

    Domain(int start, int end, int height) {
      this.start = start;
      this.end = end;
      this.height = height;
    }

    @Override
    public int compareTo(Domain target) {
      return this.start - target.start;
    }

    @Override
    public String toString() {
      return String.format("[%s, %s - %s]", start, end, height);
    }
  }

  public static void main(String[] args) {
//    System.out.println(arrayManipulation(10, new int[][]{
//        new int[]{1, 5, 3},
//        new int[]{6, 9, 1},
//        new int[]{4, 8, 7}
//    })); // 10
//    System.out.println(arrayManipulation(10, new int[][]{
//        new int[]{1, 2, 3},
//        new int[]{8, 9, 1}
//    })); // 3
//    System.out.println(arrayManipulation(10, new int[][]{
//        new int[]{1, 2, 3},
//        new int[]{1, 3, 9}
//    })); // 12
//    System.out.println(arrayManipulation(10, new int[][]{
//        new int[]{1, 4, 3},
//        new int[]{3, 4, 9}
//    })); // 12
//    System.out.println(arrayManipulation(10, new int[][]{
//        new int[]{1, 3, 3},
//        new int[]{3, 4, 9}
//    })); // 12
//    System.out.println(arrayManipulation(10, new int[][]{
//        new int[]{1, 2, 3},
//        new int[]{3, 4, 9}
//    })); // 9
//    System.out.println(arrayManipulation(10, new int[][]{
//        new int[]{-1, 8, 3},
//        new int[]{3, 4, 9}
//    })); // 12
    System.out.println(arrayManipulation(10, new int[][]{
        new int[]{8, 15, 98},
        new int[]{3, 4, 9}
    })); // 12
  }
}
