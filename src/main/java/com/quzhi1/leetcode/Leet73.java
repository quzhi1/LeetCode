package com.quzhi1.leetcode;

public class Leet73 {

    // Space O(1)
    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int col0 = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
//        printResult("Intermediate", matrix);
//        System.out.println("col0: " + col0);

        // Must be bottom up, otherwise the first row and col will be all 0 (Need to loop again)
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j > 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) { // Don't even try multiply, will overflow
                    matrix[i][j] = 0;
                }
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(final String[] args) {
        int[][] matrix1 = {{1, 1, 1},
                           {1, 0, 1},
                           {1, 1, 1}};
        setZeroes(matrix1);
        printResult("Solution", matrix1);
        int[][] matrix2 = {{0, 1, 2, 0},
                           {3, 4, 5, 2},
                           {1, 3, 1, 5}};
        setZeroes(matrix2);
        printResult("Solution", matrix2);
    }

    private static void printResult(final String label, final int[][] matrix) {
        System.out.println(label);
        if (matrix == null) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }
}
