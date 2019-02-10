package com.quzhi1.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HackerComponentsInAGraph {

  static int[] componentsInGraph(int[][] gb) {
    // Put first edge first
    if (gb.length < 1) {
      throw new RuntimeException("No min or max");
    }
    Set<Set<Integer>> componentSet = new HashSet<>();

    // Construct component set
    for (int[] edge : gb) {
      Set<Integer> mergedComponent = new HashSet<>();
      Set<Set<Integer>> newComponentSet = new HashSet<>();
      for (Set<Integer> component : componentSet) {
        if (component.contains(edge[0]) || component.contains(edge[1])) {
          mergedComponent.add(edge[0]);
          mergedComponent.add(edge[1]);
          mergedComponent.addAll(component);
        } else {
          newComponentSet.add(component);
        }
      }
      if (!mergedComponent.isEmpty()) {
        newComponentSet.add(mergedComponent);
      } else {
        newComponentSet.add(new HashSet<>(Arrays.asList(edge[0], edge[1])));
      }
      componentSet = newComponentSet;
    }

    // Find largest and smallest
    int max = 0;
    int min = Integer.MAX_VALUE;
    for (Set<Integer> component : componentSet) {
      max = Math.max(component.size(), max);
      min = Math.min(component.size(), min);
    }
    return new int[]{min, max};
  }

//  static int[] componentsInGraph(int[][] gb) {
//    // Put first edge first
//    if (gb.length < 1) {
//      throw new RuntimeException("No min or max");
//    }
//    Map<Integer, Set<Integer>> componentMap = new HashMap<>();
//
//    // Construct component set
//    for (int[] edge : gb) {
//      Set<Integer> leftSet = componentMap.get(edge[0]);
//      Set<Integer> rightSet = componentMap.get(edge[1]);
//      if (leftSet == null && rightSet == null) {
//        Set<Integer> newComponent = new HashSet<>(Arrays.asList(edge[0], edge[1]));
//        componentMap.put(edge[0], newComponent);
//        componentMap.put(edge[1], newComponent);
//      } else if (leftSet != null && rightSet == null) {
//        leftSet.add(edge[1]);
//        componentMap.put(edge[1], leftSet);
//      } else if (leftSet == null && rightSet != null) {
//        rightSet.add(edge[0]);
//        componentMap.put(edge[0], rightSet);
//      } else {
//        Set<Integer> leftKeys = new HashSet<>(leftSet);
//        for (int left: leftKeys) {
//          componentMap.get(left).addAll(rightSet);
//        }
//        Set<Integer> rightKeys = new HashSet<>(rightSet);
//        for (int right: rightKeys) {
//          componentMap.get(right).addAll(leftSet);
//        }
//      }
//    }
//
//    // Find largest and smallest
//    int max = 0;
//    int min = Integer.MAX_VALUE;
//    for (Map.Entry<Integer, Set<Integer>> component : componentMap.entrySet()) {
//      max = Math.max(component.getValue().size(), max);
//      min = Math.min(component.getValue().size(), min);
//    }
//    return new int[]{min, max};
//  }

  public static void main(String[] args) {
    int[] result = componentsInGraph(new int[][]{
        new int[]{1, 6},
        new int[]{2, 7},
        new int[]{3, 8},
        new int[]{4, 9},
        new int[]{2, 6}
    });
    System.out.println(result[0] + ", " + result[1]);
  }

}
