package com.quzhi1.leetcode;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HackerComponentsInAGraph {

//  static int[] componentsInGraphEdge(int[][] gb) {
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

  static int[] componentsInGraph(int[][] gb) {
    // Init matrix
    int[][] matrix = new int[gb.length][gb.length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[i][j] = 0;
      }
    }

    // read edge
    for (int[] edge : gb) {
      int row = edge[0] - 1;
      int col = edge[1] - gb.length - 1;
      matrix[row][col] = 1;
    }

    // find component
    int max = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < matrix.length; i++) {
      Set<Integer> componentSet = new HashSet<>();
      findComponent(i, matrix, componentSet);
      if (componentSet.size() > 1) {
//        System.out.println("ComponentNum: " + componentNum);
        max = Math.max(componentSet.size(), max);
        min = Math.min(componentSet.size(), min);
      }
    }
    return new int[]{min, max};
  }

  private static void findComponent(int row, int[][] matrix, Set<Integer> componentSet) {
    componentSet.add(row + 1);
    for (int j = 0; j < matrix[row].length; j++) {
      if (matrix[row][j] == 1) {
        matrix[row][j] = -1;
        componentSet.add(j + matrix.length + 1);
        for (int i = 0; i < matrix.length; i++) {
          if (matrix[i][j] == 1) {
            matrix[i][j] = -1;
            findComponent(i, matrix, componentSet);
          }
        }
      }
    }
  }

  public static void main(String[] args) {
//    int[] result0 = componentsInGraph(new int[][]{
//        new int[]{1, 6},
//        new int[]{2, 7},
//        new int[]{3, 8},
//        new int[]{4, 9},
//        new int[]{2, 6}
//    });
//    System.out.println(result0[0] + ", " + result0[1]); // 2, 4
//    int[] result1 = componentsInGraph(new int[][]{
//        new int[]{1, 6},
//        new int[]{2, 7},
//        new int[]{3, 8},
//        new int[]{4, 6},
//        new int[]{2, 6}
//    });
//    System.out.println(result1[0] + ", " + result1[1]); // 2, 5
//    int[] result2 = componentsInGraph(new int[][]{
//        new int[]{1, 6},
//        new int[]{1, 7},
//        new int[]{1, 8},
//        new int[]{2, 9},
//        new int[]{2, 6}
//    });
//    System.out.println(result2[0] + ", " + result2[1]); // 6, 6
//    int[] result3 = componentsInGraph(new int[][]{
//        new int[]{1, 6},
//        new int[]{2, 6},
//        new int[]{2, 7},
//        new int[]{3, 7},
//        new int[]{3, 8}
//    });
//    System.out.println(result3[0] + ", " + result3[1]); // 6, 6
//    int[] result4 = componentsInGraph(new int[][]{
//        new int[]{1, 6},
//        new int[]{2, 7},
//        new int[]{3, 8},
//        new int[]{4, 9},
//        new int[]{5, 10}
//    });
//    System.out.println(result4[0] + ", " + result4[1]); // 2, 2
//    int[] result5 = componentsInGraph(new int[][]{
//        new int[]{1, 6},
//        new int[]{2, 7},
//        new int[]{1, 7},
//        new int[]{2, 6},
//        new int[]{5, 10}
//    });
//    System.out.println(result5[0] + ", " + result5[1]); // 2, 4
//
//    int[] result6 = componentsInGraph(new int[][]{
//        new int[]{5, 56},
//        new int[]{4, 51},
//        new int[]{2, 53},
//        new int[]{8, 52},
//        new int[]{5, 43},
//        new int[]{2, 80},
//        new int[]{5, 47},
//        new int[]{4, 79},
//        new int[]{3, 75},
//        new int[]{1, 67},
//        new int[]{7, 61},
//        new int[]{2, 57},
//        new int[]{5, 47},
//        new int[]{4, 63},
//        new int[]{10, 79},
//        new int[]{1, 57},
//        new int[]{4, 42},
//        new int[]{8, 79},
//        new int[]{6, 53},
//        new int[]{3, 74},
//        new int[]{7, 60},
//        new int[]{10, 79},
//        new int[]{5, 46},
//        new int[]{3, 50},
//        new int[]{6, 57},
//        new int[]{8, 71},
//        new int[]{6, 74},
//        new int[]{10, 44},
//        new int[]{9, 80},
//        new int[]{7, 59},
//        new int[]{7, 74},
//        new int[]{6, 55},
//        new int[]{3, 77},
//        new int[]{3, 53},
//        new int[]{5, 50},
//        new int[]{9, 70},
//        new int[]{4, 72},
//        new int[]{5, 73},
//        new int[]{6, 70},
//        new int[]{7, 46}
//    });
//    System.out.println(result6[0] + ", " + result6[1]); // 11, 25

    ClassLoader classLoader = HackerComponentsInAGraph.class.getClassLoader();
    File file = new File(classLoader.getResource("HackerComponentsInAGraph20.txt").getFile());
    try (Scanner scanner = new Scanner(file)) {
      String firstLine = scanner.nextLine();
      int[][] gb = new int[Integer.parseInt(firstLine)][2];
      int i = 0;
      while (scanner.hasNextLine()) {
//        System.out.println("Reading line: " + i);
        String line = scanner.nextLine();
        String[] splitLine = line.split(" ");
        gb[i] = new int[] {Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1])};
        i++;
      }

      // Process
      int[] result7 = componentsInGraph(gb);
      System.out.println(result7[0] + ", " + result7[1]); // 2 1654
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
