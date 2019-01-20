package com.quzhi1.leetcode;

import java.util.Arrays;

public class Leet240 {

  public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    } else if (matrix.length == 1) {
      return Arrays.binarySearch(matrix[0], target) >= 0;
    } else if (matrix[0].length == 1) {
      int[] firstColumn = Arrays.stream(matrix).mapToInt(row -> row[0]).toArray();
      return Arrays.binarySearch(firstColumn, target) >= 0;
    } else {
      if (target == matrix[matrix.length / 2 - 1][matrix[0].length / 2 - 1]) {
        return true;
      } else if (target < matrix[matrix.length / 2 - 1][matrix[0].length / 2 - 1]) {
        return searchMatrix(upperLeft(matrix), target) ||
            searchMatrix(upperRight(matrix), target) ||
            searchMatrix(lowerLeft(matrix), target);
      } else {
        return searchMatrix(upperRight(matrix), target) ||
            searchMatrix(lowerLeft(matrix), target) ||
            searchMatrix(lowerRight(matrix), target);
      }
    }
  }

  private static int[][] upperLeft(int[][] matrix) {
    if (matrix.length < 2 || matrix[0].length < 2) {
      throw new RuntimeException("Shouldn't be");
    }
    int[][] result = new int[matrix.length / 2][matrix[0].length / 2];
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        result[i][j] = matrix[i][j];
      }
    }
//    System.out.println("Upper Left:");
//    printMatrix(result);
    return result;
  }

  private static int[][] upperRight(int[][] matrix) {
    if (matrix.length < 2 || matrix[0].length < 2) {
      throw new RuntimeException("Shouldn't be");
    }
    int[][] result = new int[matrix.length / 2][matrix[0].length - matrix[0].length / 2];
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        result[i][j] = matrix[i][j + matrix[0].length / 2];
      }
    }
//    System.out.println("Upper Right:");
//    printMatrix(result);
    return result;
  }

  private static int[][] lowerLeft(int[][] matrix) {
    if (matrix.length < 2 || matrix[0].length < 2) {
      throw new RuntimeException("Shouldn't be");
    }
    int[][] result = new int[matrix.length - matrix.length / 2][matrix[0].length / 2];
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        result[i][j] = matrix[i + matrix.length / 2][j];
      }
    }
//    System.out.println("Lower Left:");
//    printMatrix(result);
    return result;
  }

  private static int[][] lowerRight(int[][] matrix) {
    if (matrix.length < 2 || matrix[0].length < 2) {
      throw new RuntimeException("Shouldn't be");
    }
    int[][] result = new int[matrix.length - matrix.length / 2][matrix[0].length - matrix[0].length / 2];
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        result[i][j] = matrix[i + matrix.length / 2][j + matrix[0].length / 2];
      }
    }
//    System.out.println("Lower Right:");
//    printMatrix(result);
    return result;
  }

  private static void printMatrix(int[][] matrix) {
    Arrays.stream(matrix)
        .forEach(row -> {
          Arrays.stream(row).forEach(element -> System.out.print(element + ",\t"));
          System.out.println();
        });
    System.out.println();
  }

  public static void main(final String[] args) {
    int[][] matrix = new int[][]{
        new int[]{1, 4, 7, 11, 15},
        new int[]{2, 5, 8, 12, 19},
        new int[]{3, 6, 9, 16, 22},
        new int[]{10, 13, 14, 17, 24},
        new int[]{18, 21, 23, 26, 30}
    };
    printMatrix(matrix);

    System.out.println(searchMatrix(matrix, 3));
  }
}
