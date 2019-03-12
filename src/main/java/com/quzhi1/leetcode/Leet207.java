package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;

public class Leet207 {

  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites == null || prerequisites.length == 0 || numCourses <= 0) {
      return true;
    }
    GraphNode root = constructTopo(numCourses, prerequisites);
    Map<Integer, Set<Integer>> parents = new HashMap<>();
    return !hasCycle(root, parents);
  }

  private static GraphNode constructTopo(int numCourses, int[][] prerequisites) {
    GraphNode root = null;
    Map<Integer, GraphNode> nodeMap = new HashMap<>(numCourses);
    for (int[] edge : prerequisites) {
      nodeMap.merge(edge[1], new GraphNode(), (i1, i2) -> i1);
      nodeMap.get(edge[1]).value = edge[1];
      nodeMap.merge(edge[0], new GraphNode(), (i1, i2) -> i1);
      nodeMap.get(edge[0]).value = edge[0];
      nodeMap.get(edge[1]).nexts.add(nodeMap.get(edge[0]));
      if (root == null) {
        root = nodeMap.get(edge[1]);
      } else if (root == nodeMap.get(edge[0])) {
        root = nodeMap.get(edge[1]);
      }
    }
    return root;
  }

  private static boolean hasCycle(GraphNode root, Map<Integer, Set<Integer>> parents) {
    if (parents.containsKey(root.value) && parents.get(root.value).contains(root.value)) {
      return true;
    }
    for (GraphNode next : root.nexts) {

      parents.merge(next.value, new HashSet<>(Arrays.asList(root.value)), (i1, i2) -> {
        i1.add(root.value);
        return i1;
      });
      parents.get(next.value).addAll(parents.getOrDefault(root.value, new HashSet<>()));
      if (hasCycle(next, parents)) {
        return true;
      }
    }
    return false;
  }

  static class GraphNode {

    int value;
    List<GraphNode> nexts = new ArrayList<>();
  }

  public static void main(String[] args) {
    Assert.assertFalse(canFinish(4, new int[][]{
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
