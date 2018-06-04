package com.quzhi1.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leet365 {

    public static boolean canMeasureWater(final int x, final int y, final int z) {
        if (z > x + y) {
            return false;
        }
        if (x != y && x != 0 && y != 0) {
            return z % gcd(x, y) == 0;
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

    public static int gcd(final int a, final int b) {
        if (a == 0) {
            return 0;
        }
        int bChange = b;
        int aChange = a;
        while (bChange != 0) {
            int temp = bChange;
            bChange = aChange % bChange;
            aChange = temp;
        }
        return aChange;
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
        System.out.println(canMeasureWater(x5, y5, z5));
        int x6 = 1;
        int y6 = 1;
        int z6 = 12;
        System.out.println(canMeasureWater(x6, y6, z6));
    }

}
