package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet210 {

  public static int[] findOrder(int numCourses, int[][] prerequisites) {
    if (numCourses <= 0) {
      return new int[]{};
    }
    Map<Integer, Integer> inDegree = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      inDegree.put(i, 0);
    }
    boolean[][] ajac = constructTopo(numCourses, prerequisites, inDegree);
    List<Integer> result = new ArrayList<>();
    topoSort(ajac, inDegree, result);
    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  private static boolean[][] constructTopo(int numCourses, int[][] prerequisites, Map<Integer, Integer> inDegree) {
    boolean[][] ajac = new boolean[numCourses][numCourses];
    for (int[] edge: prerequisites) {
      ajac[edge[1]][edge[0]] = true;
      inDegree.put(edge[0], inDegree.get(edge[0]) + 1);
    }
    return ajac;
  }

  private static void topoSort(boolean[][] ajac, Map<Integer, Integer> inDegree, List<Integer> partialResult) {
    if (inDegree.isEmpty()) {
      return;
    }
    int beforeSize = inDegree.size();
    for (int i = 0; i < ajac.length; i++) {
      if (inDegree.containsKey(i) && inDegree.get(i) == 0) {
//        System.out.println("Adding: " + i);
        partialResult.add(i);
        inDegree.remove(i);
        for (int j = 0; j < ajac[0].length; j++) {
          if (ajac[i][j] && inDegree.containsKey(j) && inDegree.get(j) > 0) {
            inDegree.put(j, inDegree.get(j) - 1);
          }
        }
      }
    }
    int afterSize = inDegree.size();
    // Check cycle
    if (afterSize == beforeSize) {
      partialResult.clear();
    } else {
      topoSort(ajac, inDegree, partialResult);
    }
  }

  public static void main(String[] args) {
    Arrays.stream(findOrder(5, new int[][]{
        new int[]{2, 1},
        new int[]{4, 3},
        new int[]{2, 3},
        new int[]{3, 1}
    })).forEach(i -> System.out.print(i + ", "));
    System.out.println();
    Arrays.stream(findOrder(1, new int[][]{})).forEach(i -> System.out.print(i + ", "));
    System.out.println();
  }
}
