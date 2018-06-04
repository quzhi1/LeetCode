package com.quzhi1.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leet365 {

    public static boolean canMeasureWater(final int x, final int y, final int z) {
        if (x != y && x != 0 && y != 0) {
            int c1 = x - y > 0 ? x : y;
            int c2 = x - y > 0 ? y : x;
            int c3 = x - y > 0 ? x - y : y - x;
            int c1Max = z / c1;
            int c2Max = z / c2;
            int c3Max = z / c3;
            for (int i = 0; i <= c1Max; i++) {
                for (int j = 0; j <= c2Max; j++) {
                    for (int k = 0; k <= c3Max; k++) {
                        if (z == c1 * i + c2 * j + c3 * k) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else if (x == y && x != 0) {
            return z % x == 0;
        } else if (x == 0 && y != 0) {
            return z % y == 0;
        } else if (y == 0 && x != 0) {
            return z % x == 0;
        } else { // x == y == 0
            return z == 0;
        }
    }

    public static boolean canMeasureWaterCorrect(int x, int y, int z) {
        if (x > y) {
            return canMeasureWaterCorrect(y, x, z);
        }
        if (z > x + y) {
            return false;
        }
        Set<Integer> failSet = new HashSet<>();

        int resX = 0;
        int resY = 0;

        while (true) {
            int res = resX * x + resY * y;
            if (failSet.contains(res)) {
                return false;
            }
            if (res == z) {
                System.out.println(resX + " " + resY);
                return true;
            } else if (res < z) {
                resY++;
            } else {
                resX--;
            }
            failSet.add(res);
        }
    }

    public static void main(String[] args) {
        int x1 = 3;
        int y1 = 5;
        int z1 = 4;
        System.out.println(canMeasureWater(x1, y1, z1));
        int x2 = 2;
        int y2 = 6;
        int z2 = 5;
        System.out.println(canMeasureWater(x2, y2, z2));
        int x3 = 2;
        int y3 = 2;
        int z3 = 4;
        System.out.println(canMeasureWater(x3, y3, z3));
        int x4 = 0;
        int y4 = 0;
        int z4 = 0;
        System.out.println(canMeasureWater(x4, y4, z4));
        int x5 = 34;
        int y5 = 5;
        int z5 = 6;
        System.out.println(canMeasureWaterCorrect(x5, y5, z5));
    }

}
