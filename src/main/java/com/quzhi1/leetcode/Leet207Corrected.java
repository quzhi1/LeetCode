package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;

public class Leet207Corrected {

  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites == null || prerequisites.length == 0 || numCourses <= 0) {
      return true;
    }
    Map<Integer, Integer> inDegree = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      inDegree.put(i, 0);
    }
    boolean[][] ajac = constructTopo(numCourses, prerequisites, inDegree);
    return !hasCycle(ajac, inDegree);
  }

  private static boolean[][] constructTopo(int numCourses, int[][] prerequisites, Map<Integer, Integer> inDegree) {
    boolean[][] ajac = new boolean[numCourses][numCourses];
    for (int[] edge : prerequisites) {
      ajac[edge[1]][edge[0]] = true;
      inDegree.put(edge[0], inDegree.get(edge[0]) + 1);
    }
    return ajac;
  }

  private static boolean hasCycle(boolean[][] ajac, Map<Integer, Integer> inDegree) {
    if (inDegree.isEmpty()) {
      return false;
    }
    int beforeSize = inDegree.size();
    for (int i = 0; i < ajac.length; i++) {
      if (inDegree.containsKey(i) && inDegree.get(i) == 0) {
        inDegree.remove(i);
        for (int j = 0; j < ajac[0].length; j++) {
          if (ajac[i][j] && inDegree.containsKey(j) && inDegree.get(j) > 0) {
            inDegree.put(j, inDegree.get(j) - 1);
          }
        }
      }
    }
    int afterSize = inDegree.size();
    if (afterSize == beforeSize) {
      return true;
    } else {
      return hasCycle(ajac, inDegree);
    }
  }

  public static void main(String[] args) {
    Assert.assertFalse(canFinish(5, new int[][]{
        new int[]{2, 1},
        new int[]{4, 3},
        new int[]{2, 3},
        new int[]{3, 1},
        new int[]{1, 4}
    }));
    Assert.assertTrue(canFinish(3, new int[][]{
        new int[]{1, 0},
        new int[]{2, 1}
    }));
  }
}
